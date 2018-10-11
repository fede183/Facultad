package lafhis.NHibernateSimpleDemo.main;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Expression;
import org.hibernate.loader.GeneratedCollectionAliases;

import com.microsoft.sqlserver.jdbc.SQLServerConnection;
import com.microsoft.sqlserver.jdbc.SQLServerStatement;

public class PersistenceManager {
	// Member variables
    private static SessionFactory m_SessionFactory = null;
    private static Session m_Session = null;

    /// <summary>
    /// Default constructor.
    /// </summary>
    public PersistenceManager()
    {
        this.ConfigureLog4Net();
        this.ConfigureNHibernate();
    }

    public void Dispose()
    {
    	// TODOX
	    //m_SessionFactory.Dispose();
    }
    
    /// <summary>
    /// Clears all records from all tables in the database
    /// </summary>
    public static void ClearDatabase() throws Exception
    {
        // Initialize
        //Connection connection = m_SessionFactory.openSession().connection();
    	Session session = m_SessionFactory.openSession();
        //Statement command = null;
        String[] dataTables = new String[] { "OrderItems", "Orders", "Products", "Customers" };
        String sql = null;

        // Delete all records from all tables
        try
        {
        	// Iterate tables
            for (int i = 0; i < dataTables.length; i++)
            {
                // Build query and command, and execute
                sql = String.format("Delete from %s", dataTables[i]);
                session.createSQLQuery(sql).executeUpdate();
                /*command = connection.createStatement();
                command.execute(sql);
                command.close();*/ 
            }
        }
        catch(Exception e)
        {
            throw e;
        }
        finally
        {
        	/*connection.close();
        	m_SessionFactory.close();*/
        	session.close();
        }
    }

    /// <summary>
    /// Close this Persistence Manager and release all resources (connection pools, etc). It is the responsibility of the application to ensure that there are no open Sessions before calling Close().
    /// </summary>
    public static void Close()
	{
		m_SessionFactory.close();
	}

    /// <summary>
    /// Deletes an object of a specified type.
    /// </summary>
    /// <param name="itemsToDelete">The items to delete.</param>
    /// <typeparam name="T">The type of objects to delete.</typeparam>
    public static<T> void Delete(T item) throws Exception
    {
    	Session session = null;
        try
        {
        	session = m_SessionFactory.openSession();
            try
            {
            	session.beginTransaction();
                session.delete(item);
                session.getTransaction().commit();
            }
            catch(Exception e)
            {
            	session.getTransaction().rollback();
            	throw e;
            }
        }
        catch(Exception f)
        {
        	throw f;
        }
        finally
        {
        	if (session != null)
        		session.close();
        }
    }

    /// <summary>
    /// Deletes objects of a specified type.
    /// </summary>
    /// <param name="itemsToDelete">The items to delete.</param>
    /// <typeparam name="T">The type of objects to delete.</typeparam>
    public static<T> void Delete(ArrayList<T> itemsToDelete) throws Exception
    {
    	Session session = null;
    	try
    	{
    		session = m_SessionFactory.openSession();
    		for(Iterator<T> item = itemsToDelete.iterator(); item.hasNext();)
    		{
    			try
    			{
    				session.beginTransaction();
        			session.delete(item.next());
        			session.getTransaction().commit();	
    			}
    			catch(Exception e)
    			{
    				session.getTransaction().rollback();
    				throw e;
    			}
    		}
    	}
    	catch(Exception f)
    	{
    		throw f;
    	}
    	finally
    	{
    		if (session != null)
    			session.close();
    	}
    }

    /// <summary>
    /// Retrieves all objects of a given type.
    /// </summary>
    /// <typeparam name="T">The type of the objects to be retrieved.</typeparam>
    /// <returns>A list of all objects of the specified type.</returns>
    public List RetrieveAll(Class cls, SessionAction sessionAction)
    {
        /* Note that NHibernate guarantees that two object references will point to the
         * same object only if the references are set in the same session. For example,
         * Order #123 under the Customer object Able Inc and Order #123 in the Orders
         * list will point to the same object only if we load Customers and Orders in 
         * the same session. If we load them in different sessions, then changes that
         * we make to Able Inc's Order #123 will not be reflected in Order #123 in the
         * Orders list, since the references point to different objects. That's why we
         * maintain a session as a member variable, instead of as a local variable. */
        
        // Open a new session if specified
        if ((sessionAction == SessionAction.Begin) || (sessionAction == SessionAction.BeginAndEnd))
        {
            m_Session = m_SessionFactory.openSession();
        }

        // Retrieve all objects of the type passed in
        Criteria targetObjects = m_Session.createCriteria(cls);
        List itemList = targetObjects.list();

        // Close the session if specified
        if ((sessionAction == SessionAction.End) || (sessionAction == SessionAction.BeginAndEnd))
        {
            m_Session.close();
            //m_Session.Dispose();
        }

        // Set return value
        return itemList;
    }

    /// <summary>
    /// Retrieves objects of a specified type where a specified property equals a specified value.
    /// </summary>
    /// <typeparam name="T">The type of the objects to be retrieved.</typeparam>
    /// <param name="propertyName">The name of the property to be tested.</param>
    /// <param name="propertyValue">The value that the named property must hold.</param>
    /// <returns>A list of all objects meeting the specified criteria.</returns>
    @SuppressWarnings("deprecation")
	public List RetrieveEquals(Class cls, String propertyName, Object propertyValue) throws Exception
    {
    	Session session = null;
    	try
    	{
    		session = m_SessionFactory.openSession();    		
			// Create a criteria object with the specified criteria
            Criteria criteria = session.createCriteria(cls);
            criteria.add(Expression.eq(propertyName, propertyValue));
            
            // Get the matching objects
            List matchingObjects = criteria.list();

            // Set return value
            return matchingObjects;
    	}
    	catch(Exception e)
    	{
    		throw e;
    	}
    	finally
    	{
    		if (session != null)
    			session.close();
    	}
    }

    /// <summary>
    /// Saves an object and its persistent children.
    /// </summary>
    public static<T> void Save(T item) throws Exception
    {
    	Session session = null;
    	try
    	{
    		session = m_SessionFactory.openSession();
    		try
    		{
    			session.beginTransaction();
    			session.saveOrUpdate(item);
                	session.getTransaction().commit();
    		}
    		catch(Exception e)
    		{
    			session.getTransaction().rollback();
    			throw e;
    		}
    	}
    	catch(Exception f)
    	{
    		throw f;
    	}
    	finally
    	{
    		if (session != null)
    			session.close();
    	}
    }
	
    /// <summary>
    /// Configures Log4Net to work with NHibernate.
    /// </summary>
    private void ConfigureLog4Net()
    {
    	// TODOX
        //log4net.Config.XmlConfigurator.Configure();
    }

    /// <summary>
    /// Configures NHibernate and creates a member-level session factory.
    /// </summary>
    private void ConfigureNHibernate()
    {
        // Initialize
        Configuration cfg = new Configuration();
        cfg.configure();

        /* Note: The AddAssembly() method requires that mappings be 
         * contained in hbm.xml files whose BuildAction properties 
         * are set to -Embedded Resource-. */

        // Add class mappings to configuration object
        /*
         * TODOX
         * Assembly thisAssembly = typeof(Customer).Assembly;
        cfg.AddAssembly(thisAssembly);*/

        // Create session factory from configuration object
        m_SessionFactory = cfg.buildSessionFactory();
    }

		
}

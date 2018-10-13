package lafhis.NHibernateSimpleDemo.main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.hibernate.mapping.List;

public class Controller {
    // Member variables
    PersistenceManager m_PersistenceManager = new PersistenceManager();

    // Property variables
    private OrderSystem p_OrderSystem = new OrderSystem();

    public Controller()
    {
    }

    /// <summary>
    /// The order system for the application.
    /// </summary>
    public OrderSystem getOrderSystem()
    {
        return p_OrderSystem;
    }

    /// <summary>
    /// Clears the business object properties of the p_OrderSystem object.
    /// </summary>
    /// <param name="p_OrderSystem">The OrderSytem object for the application.</param>
    public void ClearBusinessObjects()
    {
        p_OrderSystem.getOrders().clear();
        p_OrderSystem.getCustomers().clear();
        p_OrderSystem.getCatalog().clear();
    }

    /// <summary>
    /// Clears all records from the database.
    /// </summary>
    /// <remarks>We use this method to reset the database at the beginning or each run.</remarks>
    public void ClearDatabase() throws Exception
    {
        m_PersistenceManager.ClearDatabase();
    }

    /// <summary>
    /// Converts an ICollection of dictionary keys to a string array.
    /// </summary>
    /// <param name="keys">The ICollection of keys to convert.</param>
    /// <returns>A string array of keys.</returns>
    public String[] ConvertKeys(Collection<String> keys)
    {
        int i = 0;
        String[] keyArray = new String[keys.size()];
        for (Iterator<String> key = keys.iterator(); key.hasNext();) {
            keyArray[i] = key.next();
            i++;
        }
        return keyArray;
    }

    /// <summary>
    /// Creates a new business model.
    /// </summary>
    public void CreateBusinessObjects()
    {
        p_OrderSystem.Populate();
    }

    /// <summary>
    /// Loads objects from the application database.
    /// </summary>
    /// <param name="p_OrderSystem">The OrderSytem object for the application.</param>
    /// <param name="m_PersistenceManager">The PersistenceManager for the application.</param>
    public void LoadBusinessObjects()
    {
        // Load objects
    	p_OrderSystem.setCatalog(m_PersistenceManager.RetrieveAll(Product.class, SessionAction.BeginAndEnd));
        p_OrderSystem.setCustomers(m_PersistenceManager.RetrieveAll(Customer.class, SessionAction.Begin));
        p_OrderSystem.setOrders(m_PersistenceManager.RetrieveAll(Order.class, SessionAction.End));

        // Notify the OrderSystem that it has been loaded
        p_OrderSystem.NotifyLoadComplete();
    }

    /// <summary>
    /// Performs a deletion test on the order system.
    /// </summary>
    /// <param name="p_OrderSystem">The OrderSytem object for the application.</param>
    public void PerformDeletionTest() throws Exception
    {
        // Delete Customer Able Inc. from database (should also delete Order #0)
        PersistenceManager.Delete(p_OrderSystem.getCustomers().get(0));

        /* At this point, we should have two customers, Baker Inc. and
         * Charlie Inc. We should also have two orders; Able Inc's
         * order should have been deleted. */

        // Clear business objects, then reload from database
        ClearBusinessObjects();
        LoadBusinessObjects();

    }

    /// <summary>
    /// Saves business objects to the database
    /// </summary>
    /// <param name="p_OrderSystem">The OrderSytem object for the application.</param>
    /// <param name="m_PersistenceManager">The PersistenceManager for the application.</param>
    public void SaveBusinessObjects() throws Exception
    {
        /* Note that we don't have to save the Orders list. All of the 
        * orders in the list are also in Customer.Orders lists, so when 
        * we save Customer objects, we are also saving Order objects. */

        // Save Products
        for (Iterator<Product> product = p_OrderSystem.getCatalog().iterator(); product.hasNext();)
        {
            PersistenceManager.Save(product.next());
        }

        // Save Customers (also saves Orders)
        for (Iterator<Customer> customer = p_OrderSystem.getCustomers().iterator(); customer.hasNext();)
        {
            PersistenceManager.Save(customer.next());
        }
    }

    /// <summary>
    /// Performs an object comparison to show that only one instance of an object is loaded.
    /// </summary>
    /// <param name="p_OrderSystem">The OrderSytem object for the application.</param>
    public void ShowObjectComparisons()
    {
        // Write header
        System.out.println("Object Comparison:");
        System.out.println("------------------");

        // Compare Customer #1 to the Order #1 customer--should be equal
        Customer customerA = p_OrderSystem.getCustomers().get(0);
        Customer customerB = p_OrderSystem.getOrders().get(0).getCustomer();
        Boolean sameObject = customerA == customerB;

        // Write Customer result
        System.out.println(String.format("Customer[0] equals Order[0].Customer: %s", sameObject.toString()));
        System.out.println("");

        // Compare Order #1 to the Customer #1 order--should be equal
        Order orderA = p_OrderSystem.getOrders().get(0);
        Order orderB = p_OrderSystem.getCustomers().get(0).getOrders().iterator().next();
        sameObject = customerA == customerB;

        // Write Order result
        System.out.println(String.format("Order[0] equals Customer[0].Order[0]: %s", sameObject.toString()));
        System.out.println();
    }
}

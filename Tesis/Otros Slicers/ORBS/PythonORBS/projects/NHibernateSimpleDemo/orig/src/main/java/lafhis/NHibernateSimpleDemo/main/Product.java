<<<<<<< HEAD
package lafhis.NHibernateSimpleDemo.main;

public class Product implements java.io.Serializable {
	// Property variables
    private int ID = -1;

	// Member variables
    private String Name = "";

    public Product()
    {
    }
    
    public Product(int ID, String Name)
    {
    	this.ID = ID;
    	this.Name = Name;
    }

    /// <summary>
    /// The ID of the product.
    /// </summary>
    public int getID()
    {
        return ID;
    }
    
    public void setID(int value)
    {
        ID = value;
    }

    /// <summary>
    /// The name of the product.
    /// </summary>
    public String getName()
    {
        return Name;
    }

	public void setName(String value)
	{
	    Name = value;
	}

    public String toString()
    {
        return Name;
    }
}
=======
package lafhis.NHibernateSimpleDemo.main;

public class Product implements java.io.Serializable {
	// Property variables
    private int ID = -1;

	// Member variables
    private String Name = "";

    public Product()
    {
    }
    
    public Product(int ID, String Name)
    {
    	this.ID = ID;
    	this.Name = Name;
    }

    /// <summary>
    /// The ID of the product.
    /// </summary>
    public int getID()
    {
        return ID;
    }
    
    public void setID(int value)
    {
        ID = value;
    }

    /// <summary>
    /// The name of the product.
    /// </summary>
    public String getName()
    {
        return Name;
    }

	public void setName(String value)
	{
	    Name = value;
	}

    public String toString()
    {
        return Name;
    }
}
>>>>>>> 3e88ea80f0834d4037ab054f53ebbe65ed116e98

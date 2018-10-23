package lafhis.NHibernateSimpleDemo.main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Customer implements java.io.Serializable {
	// Property variables
	public Address Address = new Address();
	public int ID = -1;
	public String Name = "[New Customer]";
	public Collection Orders = new ArrayList<Order>();

	public Customer()
    {

    }
	
	public Customer(Collection<Order> Orders, String Name)
    {
		this.Orders = Orders;
		this.Name = Name;
    }
	
	public Customer(Address Address, Collection<Order> Orders, String Name)
    {
		this.Address = Address;
		this.Name = Name;
		this.Orders = Orders;
    }
	
	public Customer(int ID, Address Address, String Name, Collection<Order> Orders)
    {
		this.ID = ID;
		this.Address = Address;
		this.Name = Name;
		this.Orders = Orders;
    }

	/// <summary>
    /// The customer's address.
    /// </summary>
	public Address getAddress()
    {
        return Address;
    }
    
    public void setCity(Address address)
    {
    	Address = address;
    }
	
    /// <summary>
    /// The customer number of this customer
    /// </summary>
    /// <remarks>This value is assigned by the system.</remarks>
    public int getID()
    {
        return ID;
    }
    
    public void setID(int id)
    {
    	ID = id;
    }
    
    /// <summary>
    /// The customer's name
    /// </summary>
    /// <remarks>For simplicity, we only use one name field, instead of first name, last name, and so on.</remarks>
    public String getName()
    {
        return Name;
    }
    
    public void setName(String name)
    {
    	Name = name;
    }

    /// <summary>
    /// All orders placed by this customer.
    /// </summary>
    public Collection<Order> getOrders()
    {
    	return Orders;
    }
    
    public void setOrders(Collection<Order> orders)
    {
    	Orders = orders;
    }

    public String toString()
    {
        return Name;
    }
}
package lafhis.NHibernateSimpleDemo.main;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

public class Order implements java.io.Serializable {
	// Property variables
    public Customer Customer = null;
    public Date Date = new Date(0, 0, 0);
    public int ID = -1;
    public Collection<Product> OrderItems = new ArrayList<Product>();

	// Member variables
    public Order()
    {
    }
    
    public Order(Customer Customer, Collection<Product> OrderItems, Date Date)
    {
    	this.Customer = Customer;
    	this.OrderItems = OrderItems;
    	this.Date = Date;
    }
    
    public Order(int ID, Customer Customer, Collection<Product> OrderItems, Date Date)
    {
    	this.ID = ID;
    	this.Customer = Customer;
    	this.OrderItems = OrderItems;
    	this.Date = Date;
    }

    /// <summary>
    /// The customer who placed the order.
    /// </summary>
    public Customer getCustomer()
    {
        return Customer;
    }
    
    public void setCustomer(Customer customer)
    {
    	Customer = customer;
    }
    
    /// <summary>
    /// The date of the order.
    /// </summary>
    public Date getDate()
    {
        return Date;
    }
    
    public void setDate(Date date)
    {
    	Date = date;
    }

    /// <summary>
    /// The order number of the order.
    /// </summary>
    /// <value>This value is assigned by the system.</value>
    public int getID()
    {
    	 return ID;
    }
     
    public void setID(int id)
    {
    	 ID = id;
    }
     
    /// <summary>
    /// The products purchased in this order.
    /// </summary>
    public Collection<Product> getOrderItems()
    {
        return OrderItems;
    }
    
    public void setOrderItems(Collection<Product> orderItems)
    {
    	OrderItems = orderItems;
    }
    
    public String ToString()
    {
        String orderID = null;
        if (ID == -1)
        {
            orderID = "Unsaved Order";
        }
        else
        {
            orderID = "Order #" + Integer.toString(ID);
        }

        return  Customer.getName() + ", " + orderID.toString() + ", " + Date.toString();
    }
}
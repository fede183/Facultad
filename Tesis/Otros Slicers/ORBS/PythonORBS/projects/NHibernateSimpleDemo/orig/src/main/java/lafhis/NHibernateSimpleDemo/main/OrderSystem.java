package lafhis.NHibernateSimpleDemo.main;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class OrderSystem {
	// Events
    //public event EventHandler Populated;

	// Property variables
    private List<Product> p_Catalog = new ArrayList<Product>();
    private List<Customer> p_Customers = new ArrayList<Customer>();
    private List<Order> p_Orders = new ArrayList<Order>();

    // Member variables
    private Random m_RandomNumberGenerator = new Random();

    /// <summary>
    /// The seller's product catalog.
    /// </summary>
    public List<Product> getCatalog()
    {
        return p_Catalog;
    }
    
    public void setCatalog(List<Product> value)
    {
        p_Catalog = value;
    }

    /// <summary>
    /// The list of customers in the system.
    /// </summary>
    public List<Customer> getCustomers()
    {
        return p_Customers;
    }
    
    public void setCustomers(List<Customer> value)
    {
        p_Customers = value;
    }

    /// <summary>
    /// The list of orders in the system.
    /// </summary>
    public List<Order> getOrders()
    {
        return p_Orders;
    }
    
    public void setOrders(List<Order> value)
    {
        p_Orders = value;
    }

    /// <summary>
    /// Notifies the rest of the application that the order system has been loaded.
    /// </summary>
    public void NotifyLoadComplete()
    {
        // Fire event
        this.FirePopulatedEvent();
    }

    /// <summary>
    /// Populates the order system with business objects.
    /// </summary>
    public void Populate()
    {
        // Create business objects
        this.CreateProducts();
        this.CreateCustomers();
        this.CreateOrders();

        // Fire event
        this.FirePopulatedEvent();
    }

    /// <summary>
    /// Invokes the Populated event.
    /// </summary>
    void FirePopulatedEvent()
    {
    	Program.OrderSystem_Populated(this);
    }

    /// <summary>
    /// Adds three different customers to the customer list.
    /// </summary>
    /// <param name="m_OrderSystem">The OrderSytem object for the application.</param>
    private void CreateCustomers()
    {
        // Create data array
        String[][] customerData = new String[][]
        {
            {"Able, Inc.", "100 Main Street", "Chicago", "IL", "60601"},
            {"Baker, Inc.", "200 Main Street", "Chicago", "IL", "60601"},
            {"Charlie, Inc.", "100 Main Street", "Chicago", "IL", "60601"},
        };

        // Create customer list
        Customer newCustomer = null;
        for (int i = 0; i < 3; i++)
        {
            // Create new customer
            newCustomer = new Customer();

            // Set name and address
            newCustomer.setName(customerData[i][0]);
            newCustomer.getAddress().setStreetAddress(customerData[i][1]);
            newCustomer.getAddress().setCity(customerData[i][2]);
            newCustomer.getAddress().setState(customerData[i][3]);
            newCustomer.getAddress().setZip(customerData[i][4]);

            // Add customer to list
            p_Customers.add(newCustomer);
        }
    }

    /// <summary>
    /// Add two orders for each customer
    /// </summary>
    /// <param name="m_OrderSystem">The OrderSytem object for the application.</param>
    private void CreateOrders()
    {
        // Initialize
        Customer customer = null;
        Order order = null;

        // Iterate customers
        for (int i = 0; i < 3; i++)
        {
            // Create one new order for each customer
            customer = this.p_Customers.get(i);
            order = new Order();
            order.setDate(new Date(0,0,0));
            order.setCustomer(customer);

            // Add four products to the order
            order.setOrderItems(this.GetRandomProducts());

            // Add the order to the Customer object 
            customer.getOrders().add(order);

            // Add the order to the Orders list
            p_Orders.add(order);
        }
    }

    /// <summary>
    /// Adds ten different products to the product catalog.
    /// </summary>
    /// <param name="m_OrderSystem">The OrderSytem object for the application.</param>
    private void CreateProducts()
    {
        // Create data array
        String[] productName = new String[10];
        for (int i = 0; i < 10; i++)
        {
            productName[i] = "Widget, Type " + Integer.toString(i);
        }

        // Create product list
        Product newProduct = null;
        for (int i = 0; i < 10; i++)
        {
            // Set product properties
            newProduct = new Product();
            newProduct.setName(productName[i]);

            // Add product to catalog
            p_Catalog.add(newProduct);
        }
    }

    /// <summary>
    /// Gets four random product from the product list, with no duplications.
    /// </summary>
    /// <param name="products">The Products list from the order system.</param>
    /// <returns></returns>
    public ArrayList<Product> GetRandomProducts()
    {
        /* To ensure uniqueness, we first create a list of product IDs.
         * Then we generate a random number to pull an ID from the list,
         * adter which we delete the ID from the list. That way, even if 
         * the same random number is generated twice, the product ID
         * selected will be unique. */

        // Initialize 
        int productID = -1;
        ArrayList<Product> results = new ArrayList<Product>();

        // Create a list of product IDs
        ArrayList<Integer> productIdList = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++)
        {
            productIdList.add(i);
        }

        // Grab four products at random
        for (int i = 0; i < 4; i++)
        {
            // Get a random number
            int n = m_RandomNumberGenerator.nextInt(productIdList.size() - 1);

            // Get a product ID, then delete it
            productID = productIdList.get(n);
            productIdList.remove(n);

            // And add the product to the results list
            results.add(p_Catalog.get(productID));
        }

        // Set return value
        return results;
    }
}

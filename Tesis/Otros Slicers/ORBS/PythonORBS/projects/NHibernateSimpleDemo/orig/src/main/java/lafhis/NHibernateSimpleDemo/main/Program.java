<<<<<<< HEAD
package lafhis.NHibernateSimpleDemo.main;

import java.util.Iterator;

public class Program {
	/// <summary>
    /// The main method for the program
    /// </summary>
    /// <remarks>Normally, a Controller class (or classes) would do most of the
    /// work that this method does. The Controller would receive requests from
    /// the UI and manipulate the business model to perform the requested action.</remarks>
	public static void main( String[] args ) throws Exception
    {
        /* Since the Program class represents the UI of the application, it has
         * very limited knowledge of the model--only enough to subscribe to the
         * Populate event. If we wanted to be very strict, we could route that
         * event through the Controller, which would subscribe to the model's
         * event, then fires one of its own to pass the event to the UI. That
         * approach would completely eliminate the UI's knowledge of the model. 
         * In that case, the OrderSystem object would not be a property of the
         * Controller, but a member variable instead. */

        // Initialize 
        Controller controller = new Controller();
        //controller.OrderSystem.Populated +=new EventHandler(OrderSystem_Populated);

        // Pause to let the user examine console
        System.out.println("Completed NHibernate configuration\r\nNext step: Clear database from last run");

        // Clear the database
        controller.ClearDatabase();
        System.out.println("Completed clearing the database from last run\r\nNext step: Create business objects");

        // Get persistent objects
        controller.CreateBusinessObjects();
        System.out.println("Completed creating business objects\r\nNext step: Saving business objects to database");

        // Save order system
        controller.SaveBusinessObjects();
        System.out.println("Completed saving business objects\r\nNext step: Clear business objects from memory");

        // Clear business objects
        controller.ClearBusinessObjects();
        System.out.println("Completed clearing business objects from memory\r\nNext step: Reload business objects from database");

        // Reload objects
        controller.LoadBusinessObjects();
        System.out.println("Completed reloading business objects\r\nNext step: Object comparison");

        // Show object comparison
        controller.ShowObjectComparisons();
        System.out.println("Completed object comparisons\r\nNext step: Deletion test");

        // Perform deletion test
        System.out.println("Beginning deletion test");
        controller.PerformDeletionTest();
        //System.out.println("Completed deletion test (should be 2 Customers)\r\nApplication run completed");
    }

    /// <summary>
    /// Prints a customer and order list when the order system is populated.
    /// </summary>
    static void OrderSystem_Populated(OrderSystem sender)
    {
        OrderSystem orderSystem = sender;
        ShowCustomersAndOrders(orderSystem);
    }

    /// <summary>
    /// Outputs a message to the user on the console.
    /// </summary>
    /// <param name="message">The message to output.</param>
    private static void Notify(String message)
    {
        System.out.println(String.format("%s\r\n", message));
    }

    /// <summary>
    /// Pauses until the user hits Enter.
    /// </summary>
    private static void Pause(String prompt)
    {
        System.out.println(String.format("\r\n%s", prompt));
        System.out.println("\r\nHit the Enter key to continue");
        //Console.ReadLine();
    }
    
    /// <summary>
    /// Prints a list of customers and their orders.
    /// </summary>
    /// <param name="m_OrderSystem">The OrderSytem object for the application.</param>
    private static void ShowCustomersAndOrders(OrderSystem orderSystem)
    {
        // Initialize
        Customer customer = null;
        Order order = null;

        // Print header
        System.out.println("Customers and their orders:");
        System.out.println("---------------------------------");

        // Print customers and orders
        //for (int i = 0; i < orderSystem.getCustomers().size(); i++)
        int counter = 0;
        for (Iterator<Customer> i = orderSystem.getCustomers().iterator(); i.hasNext();)
        {
            customer = i.next();
            System.out.println(String.format("Customer #%s: %s", Integer.toString(counter++), customer.getName()));
            //for (int j = 0; j < customer.getOrders().size(); j++)
            for (Iterator<Order> j = customer.getOrders().iterator(); j.hasNext();)
            {
                order = j.next();
                System.out.println(String.format("-->Order dated %s", order.getDate()));
            }

            //for (int k = 0; k < order.getOrderItems().size(); k++)
            int pCounter = 0;
            for (Iterator<Product> k = order.getOrderItems().iterator(); k.hasNext();)
            {
		String p = k.next().getName();
                System.out.println(String.format("---->Order item #%s: %s", Integer.toString(pCounter++), ""));
            }
        }

        // Skip line
        System.out.println();
	System.out.println(Integer.toString(counter));
    }
}
=======
package lafhis.NHibernateSimpleDemo.main;

import java.util.Iterator;

public class Program {
	/// <summary>
    /// The main method for the program
    /// </summary>
    /// <remarks>Normally, a Controller class (or classes) would do most of the
    /// work that this method does. The Controller would receive requests from
    /// the UI and manipulate the business model to perform the requested action.</remarks>
	public static void main( String[] args ) throws Exception
    {
        /* Since the Program class represents the UI of the application, it has
         * very limited knowledge of the model--only enough to subscribe to the
         * Populate event. If we wanted to be very strict, we could route that
         * event through the Controller, which would subscribe to the model's
         * event, then fires one of its own to pass the event to the UI. That
         * approach would completely eliminate the UI's knowledge of the model. 
         * In that case, the OrderSystem object would not be a property of the
         * Controller, but a member variable instead. */

        // Initialize 
        Controller controller = new Controller();
        //controller.OrderSystem.Populated +=new EventHandler(OrderSystem_Populated);

        // Pause to let the user examine console
        System.out.println("Completed NHibernate configuration\r\nNext step: Clear database from last run");

        // Clear the database
        controller.ClearDatabase();
        System.out.println("Completed clearing the database from last run\r\nNext step: Create business objects");

        // Get persistent objects
        controller.CreateBusinessObjects();
        System.out.println("Completed creating business objects\r\nNext step: Saving business objects to database");

        // Save order system
        controller.SaveBusinessObjects();
        System.out.println("Completed saving business objects\r\nNext step: Clear business objects from memory");

        // Clear business objects
        controller.ClearBusinessObjects();
        System.out.println("Completed clearing business objects from memory\r\nNext step: Reload business objects from database");

        // Reload objects
        controller.LoadBusinessObjects();
        System.out.println("Completed reloading business objects\r\nNext step: Object comparison");

        // Show object comparison
        controller.ShowObjectComparisons();
        System.out.println("Completed object comparisons\r\nNext step: Deletion test");

        // Perform deletion test
        System.out.println("Beginning deletion test");
        controller.PerformDeletionTest();
        //System.out.println("Completed deletion test (should be 2 Customers)\r\nApplication run completed");
    }

    /// <summary>
    /// Prints a customer and order list when the order system is populated.
    /// </summary>
    static void OrderSystem_Populated(OrderSystem sender)
    {
        OrderSystem orderSystem = sender;
        ShowCustomersAndOrders(orderSystem);
    }

    /// <summary>
    /// Outputs a message to the user on the console.
    /// </summary>
    /// <param name="message">The message to output.</param>
    private static void Notify(String message)
    {
        System.out.println(String.format("%s\r\n", message));
    }

    /// <summary>
    /// Pauses until the user hits Enter.
    /// </summary>
    private static void Pause(String prompt)
    {
        System.out.println(String.format("\r\n%s", prompt));
        System.out.println("\r\nHit the Enter key to continue");
        //Console.ReadLine();
    }
    
    /// <summary>
    /// Prints a list of customers and their orders.
    /// </summary>
    /// <param name="m_OrderSystem">The OrderSytem object for the application.</param>
    private static void ShowCustomersAndOrders(OrderSystem orderSystem)
    {
        // Initialize
        Customer customer = null;
        Order order = null;

        // Print header
        System.out.println("Customers and their orders:");
        System.out.println("---------------------------------");

        // Print customers and orders
        //for (int i = 0; i < orderSystem.getCustomers().size(); i++)
        int counter = 0;
        for (Iterator<Customer> i = orderSystem.getCustomers().iterator(); i.hasNext();)
        {
            customer = i.next();
            System.out.println(String.format("Customer #%s: %s", Integer.toString(counter++), customer.getName()));
            //for (int j = 0; j < customer.getOrders().size(); j++)
            for (Iterator<Order> j = customer.getOrders().iterator(); j.hasNext();)
            {
                order = j.next();
                System.out.println(String.format("-->Order dated %s", order.getDate()));
            }

            //for (int k = 0; k < order.getOrderItems().size(); k++)
            int pCounter = 0;
            for (Iterator<Product> k = order.getOrderItems().iterator(); k.hasNext();)
            {
		String p = k.next().getName();
                System.out.println(String.format("---->Order item #%s: %s", Integer.toString(pCounter++), ""));
            }
        }

        // Skip line
        System.out.println();
	System.out.println(Integer.toString(counter));
    }
}
>>>>>>> 3e88ea80f0834d4037ab054f53ebbe65ed116e98

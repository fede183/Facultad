package lafhis.NHibernateSimpleDemo.main;

public class Address implements java.io.Serializable {
	// Property variables
	public String City = "";
	public String State = "";
	public String StreetAddress = "";
	public String Zip = "";

    public Address()
    {
    	
    }
    
    public Address(String City, String State, String StreetAddress, String Zip)
    {
    	this.City = City;
    	this.State = State;
    	this.StreetAddress = StreetAddress;
    	this.Zip = Zip;
    }
    
	// Member variables
    /// <summary>
    /// The city portion of the customer's address.
    /// </summary>
    public String getCity()
    {
        return City;
    }
    
    public void setCity(String city)
    {
        City = city;
    }

    /// <summary>
    /// The street address portion of the customer's address.
    /// </summary>
    public String getStreetAddress()
    {
        return StreetAddress;
    }
    
    public void setStreetAddress(String streetAddress)
    {
    	StreetAddress = streetAddress;
    }

    /// <summary>
    /// The state portion of the customer's address.
    /// </summary>
    public String getState()
    {
        return State;
    }
    
    public void setState(String state)
    {
    	State = state;
    }

    /// <summary>
    /// The zip code portion of the customer's address.
    /// </summary>
    public String getZip()
    {
        return Zip;
    }
    
    public void setZip(String zip)
    {
    	Zip = zip;
    }
}

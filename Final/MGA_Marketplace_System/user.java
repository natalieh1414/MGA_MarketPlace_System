/****************************************
* Student Name: Natalie Houser
* Date Due:	May 1st, 2024
* Date Submitted: May 1st, 2024
* Program Name:	MGA_MarketPlace_System
* Program Description: User-to-user marketplace for buying and
selling used smartphones, called MGA Marketplace System. The sellers can register their used
smartphones and the buyers can purchase the smartphones registered. The system needs to
keep track of smartphones and users (buyers and sellers) information.
****************************************/

//This file is for user information 
public class user {
		private String firstName;
	    private String lastName;
	    private String telephoneNumber;
	    private String emailAddress;
	    private String username;
	    private String role;
	    
	 //constructor for user
	    public user(String firstName, String lastName, String telephoneNumber, 
	    		String emailAddress, String username, String role) {
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.telephoneNumber = telephoneNumber;
	        this.emailAddress = emailAddress;
	        this.username = username;
	        this.role = role;
	    }

	    //getters and setters for constructor
	    public String getFirstName() {
	        return firstName;
	    }

	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }

	    public String getLastName() {
	        return lastName;
	    }

	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }

	    public String getTelephoneNumber() {
	        return telephoneNumber;
	    }

	    public void setTelephoneNumber(String telephoneNumber) {
	        this.telephoneNumber = telephoneNumber;
	    }

	    public String getEmailAddress() {
	        return emailAddress;
	    }

	    public void setEmailAddress(String emailAddress) {
	        this.emailAddress = emailAddress;
	    }

	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    public String getRole() {
	        return role;
	    }

	    public void setRole(String role) {
	        this.role = role;
	    }
	}

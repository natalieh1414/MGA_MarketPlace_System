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

//This file is for smartphone information
public class smartphone {

    private String registrationNum;
    private String model;
    private String manufacturer;
    private double price;
    private String sellerUsername;
    private String soldStatus;

    //constructor for smartphone
    public smartphone(String registrationNum, String model, String manufacturer, 
    				  String price, String sellerUsername, String soldStatus) {
        this.registrationNum = registrationNum;
        this.model = model;
        this.manufacturer = manufacturer;
        try {
            this.price = Double.parseDouble(price);
        } catch (NumberFormatException e) {
            System.out.println("Invalid price format. Please enter a valid numeric value.");
            this.price = 0.0; 						//set default price to handle the error
        }
        this.sellerUsername = sellerUsername;
        this.soldStatus = soldStatus;
    }
    
    //getters and setters for smartphone fields
    public String getRegistrationNum() {
        return registrationNum;
    }

    public void setRegistrationNum(String registrationNum) {
        this.registrationNum = registrationNum;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSellerUsername() {
        return sellerUsername;
    }

    public void setSellerUsername(String sellerUsername) {
        this.sellerUsername = sellerUsername;
    }

    public String getSoldStatus() {
        return soldStatus;
    }

    public void setSoldStatus(String soldStatus) {
        this.soldStatus = soldStatus;
    }

}


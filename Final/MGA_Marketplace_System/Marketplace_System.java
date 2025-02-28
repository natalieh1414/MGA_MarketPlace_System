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

//This file has the main methods and menu for the MGA Marketplace System
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Marketplace_System {
	 private List<user> users;
	 private List<smartphone> smartphones;

	    //constructor for system
	    public Marketplace_System() {
	        this.users = new ArrayList<>();
	        this.smartphones = new ArrayList<>();
	    }

	    //method to register a new user with user input
	    public void registerUser() {
	    	//new scanner
	    	Scanner scanner = new Scanner(System.in);
	    		//scanners for user information
		        System.out.println("Enter first name:");
		        String firstName = scanner.nextLine();
	
		        System.out.println("Enter last name:");
		        String lastName = scanner.nextLine();
	
		        System.out.println("Enter telephone number:");
		        String telephoneNumber = scanner.nextLine();
	
		        System.out.println("Enter email address:");
		        String emailAddress = scanner.nextLine();
	
		        System.out.println("Enter username:");
		        String username = scanner.nextLine();
	
		        System.out.println("Enter role (Buyer or Seller):");
		        String role = scanner.nextLine();
		        
	        
	    	//new user object
	        user newUser = new user(firstName, lastName, telephoneNumber, 
	        		emailAddress, username, role);
	        users.add(newUser);
	        System.out.println("User registered successfully.");
	        
	    }
	    
	 //method to remove a user
	    public void removeUser(String usernameToRemove) {
	        // Check if there are any users to remove
	        if (users.isEmpty()) {
	            System.out.println("There are no users to remove.");
	            return;
	        }


	        // Find the user by username
	        user foundUser = null;
	        for (user currentUser : users) {
	            if (currentUser.getUsername().equalsIgnoreCase(usernameToRemove)) {
	                foundUser = currentUser;
	                break;
	            }
	        }

	        // Check if the user was found
	        if (foundUser != null) {
	            // New scanner
	            Scanner scanner = new Scanner(System.in);

	            // Prompt for confirmation
	            System.out.println("Are you sure you want to remove the user " + foundUser.getUsername() + "? (yes/no)");
	            String confirmation = scanner.nextLine().trim().toLowerCase();

	            // Remove the user if confirmed
	            if (confirmation.equals("yes")) {
	                users.remove(foundUser);
	                System.out.println("User " + foundUser.getUsername() + " removed successfully.");
	            } else {
	                System.out.println("User removal cancelled.");
	            }
	        } else {
	            System.out.println("User not found.");
	        }
	    }

	    
	  //method to register a new smartphone with user input from seller
	    public void registerSmartphone() {
	    	
	    	   //new scanner
	    	   Scanner scanner = new Scanner(System.in);

	    	    System.out.println("Enter Seller's username:");
	    	    String sellerUsername = scanner.nextLine();

	    	    //find the seller by username
	    	    user seller = null;
	    	    for (user u : users) {
	    	        if (u.getUsername().equalsIgnoreCase(sellerUsername)) {
	    	            seller = u;
	    	            break;
	    	        }
	    	    }

	    	    //check if the seller exists
	    	    if (seller != null) {
	    	        //check if the user is a seller
	    	        if (seller.getRole().equalsIgnoreCase("seller")) {
	    	            // Scanners for smartphone information
	    	            System.out.println("Enter Registration #:");
	    	            String registrationNum = scanner.nextLine();

	    	            System.out.println("Enter Model:");
	    	            String model = scanner.nextLine();

	    	            System.out.println("Enter Manufacturer:");
	    	            String manufacturer = scanner.nextLine();

	    	            System.out.println("Enter price:");
	    	            String price = scanner.nextLine();

	    	            System.out.println("Enter Sold or Not (Yes or No):");
	    	            String soldStatus = scanner.nextLine();

	    	            //new smartphone object
	    	            smartphone newSmartPhone = new smartphone(registrationNum, model, manufacturer, price, sellerUsername, soldStatus);

	    	            //if the smartphone is sold, update its status and remove it from the list
	    	            if (soldStatus.equalsIgnoreCase("yes")) {
	    	                System.out.println("Smartphone is marked as sold.");
	    	            } else {
	    	                smartphones.add(newSmartPhone);
	    	                System.out.println("Smartphone registered successfully.");
	    	            }
	    	        } else {
	    	            System.out.println("User '" + sellerUsername + "' is not a seller.");
	    	        }
	    	    } else {
	    	        System.out.println("Seller with username '" + sellerUsername + "' not found.");
	    	    }
	    	}
		 
	    
	 //method to remove a smartphone
	    public void removeSmartphone(smartphone smartphoneToRemove) {
	       //new scanner
	    	Scanner scanner = new Scanner(System.in);
	        System.out.println("Are you sure you want to remove the smartphone " + 
	        smartphoneToRemove.getRegistrationNum() + "? (yes/no)");
	        String confirmation = scanner.nextLine().trim().toLowerCase();

	        if (confirmation.equals("yes")) {
	            if (smartphones.remove(smartphoneToRemove)) {
	                System.out.println("Smartphone " + smartphoneToRemove.getRegistrationNum()
	                + " removed successfully.");
	            } else {
	                System.out.println("Smartphone not found.");
	            }
	        } else {
	            System.out.println("Smartphone removal cancelled.");
	        }
	        
	    }
	    
	    //method to handle the transaction when a buyer purchases smartphones
	    public void handleTransaction(user buyer, List<smartphone> selectedSmartphones) {
	    	double totalAmount = 0.0;
	    	//check if there are any smartphones to buy
	    	if (selectedSmartphones.isEmpty()) {
	    		System.out.println("No smartphones selected for purchase.");
	    		return;
	    	}
	    	
	    	//check if user is buyer
	    	 //new scanner
	    	   Scanner scanner = new Scanner(System.in);

	    	    System.out.println("Enter Buyer's username:");
	    	    String buyerUsername = scanner.nextLine();

	    	    //find the buyer by username
	    	    user foundBuyer = null;
	    	    for (user u : users) {
	    	        if (u.getUsername().equalsIgnoreCase(buyerUsername)) {
	    	            foundBuyer = u;
	    	            break;
	    	        }
	    	    }

	    	    //check if the beller exists
	    	    if (foundBuyer != null) {
	    	        //check if the beller is a beller
	    	        if (foundBuyer.getRole().equalsIgnoreCase("buyer")) {
	    	        	
					        //display transaction details header
					        System.out.println("Transaction Details:");
					        System.out.println("Username: " + foundBuyer.getUsername());
					        System.out.println("Role: " + foundBuyer.getRole());
					        System.out.println("Name: " + foundBuyer.getFirstName() + " " + foundBuyer.getLastName());
					        System.out.println("The smartphones to purchase are as below:");
				
					        //display smartphone details
					        System.out.println("# Registration # Manufacturer Model Price");
					        for (smartphone smartphone : selectedSmartphones) {
					            System.out.println(
					                smartphone.getRegistrationNum() + " " +
					                smartphone.getManufacturer() + " " +
					                smartphone.getModel() + " $" +
					                smartphone.getPrice()
					            );
					            totalAmount += smartphone.getPrice();
					            
					            //update smartphone status
					            smartphone.setSoldStatus("sold");
					        }

				        //display total amount
				        System.out.println("Total: $" + totalAmount);
	    	        }
	    	    }
	    }
	    
	    //method to display user information
	    public void displayUserInfo() {
	        System.out.println("User Information:");
	        System.out.println("Name\t\tTelephone\tEmail\t\t\tUsername\tRole");
	        for (user currentUser : users) {
	            System.out.println(currentUser.getFirstName() + " " + currentUser.getLastName() + "\t"
	                    + currentUser.getTelephoneNumber() + "\t" + currentUser.getEmailAddress() + "\t"
	                    + currentUser.getUsername() + "\t" + currentUser.getRole());
	        }
	    }

	    //method to display smartphone information
	    public void displaySmartphoneInfo() {
	        System.out.println("Smartphone Information:");
	        System.out.println("Registration #\tModel\tManufacturer\tPrice\tSeller's Username\tSold Status");
	        for (smartphone currentSmartphone : smartphones) {
	            System.out.println(currentSmartphone.getRegistrationNum() + "\t\t" + currentSmartphone.getModel() + "\t"
	                    + currentSmartphone.getManufacturer() + "\t\t$" + currentSmartphone.getPrice() + "\t"
	                    + currentSmartphone.getSellerUsername() + "\t\t" + currentSmartphone.getSoldStatus());
	        }
	    }
	    
//main method
	    public static void main(String[] args) {
	        Marketplace_System marketplace = new Marketplace_System();
	        Scanner scanner = new Scanner(System.in);
	        boolean running = true;

	        while (running) {
	            System.out.println("1. Register a New User");
	            System.out.println("2. Remove a User");
	            System.out.println("3. Register a New Smartphone");
	            System.out.println("4. Remove a Smartphone");
	            System.out.println("5. Purchase a Smartphone");
	            System.out.println("6. Display User Information");
	            System.out.println("7. Display Smartphone Information");
	            System.out.println("8. Exit");
	            System.out.print("Choose an Option: ");

	            int choice = 0;
	            boolean validInput = false;
	            while (!validInput) {
	                try {
	                    choice = Integer.parseInt(scanner.nextLine());
	                    validInput = true;
	                } catch (NumberFormatException e) {					//error to handle any non-number inputs
	                    System.out.println("Invalid input. Please enter a number.");
	                    System.out.print("Choose an option: ");
	                }
	            }

	            switch (choice) {
	                case 1:
	                    marketplace.registerUser();
	                    break;
	                case 2:
	                    // Remove a specific user
	                    if (!marketplace.users.isEmpty()) {
	                        System.out.println("Enter username of user to remove:");
	                        String username = scanner.nextLine().trim();
	                        marketplace.removeUser(username);
	                    } else {
	                        System.out.println("No users to remove.");
	                    }
	                    break;

	                case 3:
	                    marketplace.registerSmartphone();
	                    break;
	                case 4:
	                    //remove the first smartphone in the list
	                    if (!marketplace.smartphones.isEmpty()) {
	                        marketplace.removeSmartphone(marketplace.smartphones.get(0));
	                    } else {
	                        System.out.println("No smartphones to remove.");
	                    }
	                    break;
	                case 5:
	                	 // Check if there are users and smartphones in the system
	                    if (marketplace.users.isEmpty() || marketplace.smartphones.isEmpty()) {
	                        System.out.println("No users or smartphones available.");
	                    } else {
	                        user buyer = marketplace.users.get(0);

	                        //display available smartphones for purchase
	                        System.out.println("Available Smartphones for Purchase:");
	                        for (int i = 0; i < marketplace.smartphones.size(); i++) {
	                            smartphone smartphone = marketplace.smartphones.get(i);
	                            System.out.println((i+1) + ". " + smartphone.getManufacturer() + " " + smartphone.getModel());
	                        }

	                        //ask the buyer to select smartphones for purchase
	                        System.out.println("Enter the numbers of smartphones you want to purchase (comma-separated):");
	                        String input = scanner.nextLine();
	                        String[] selectedIndices = input.split(",");
	                        List<smartphone> selectedSmartphones = new ArrayList<>();

	                        //add selected smartphones to the list
	                        for (String index : selectedIndices) {
	                            int selectedIndex = Integer.parseInt(index.trim());
	                            if (selectedIndex >= 1 && selectedIndex <= marketplace.smartphones.size()) {
	                                selectedSmartphones.add(marketplace.smartphones.get(selectedIndex - 1));
	                            }
	                        }

	                        //handle the transaction
	                        marketplace.handleTransaction(buyer, selectedSmartphones);
	                    }
	                	break;
	                case 6:
	                	marketplace.displayUserInfo();
	                	break;
	                case 7:
	                	marketplace.displaySmartphoneInfo();
	                	break;
	                case 8:
	                    running = false;
	                    System.out.println("Goodbye!");
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please enter a number between 1 and 8.");
	            }
	        }

	        //close scanner after the loop ends
	        scanner.close();
	    }
}

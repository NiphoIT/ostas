package com.satso.nhl.SatsoAssess;


import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
	
	
		List<Customer> customers;
		
		
		/*//JDBC Drivers 
		private String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		private String DB_URL = "jdbc:mysql://localhost:3306/satsodb";
		
		//JDBC Connector
		private Connection con = null;
		private Statement stm = null;
		
		//Database cred
	    private String user = "root";
	    private String pass = "admin";*/
	    
	    public CustomerRepository() {
	    	customers = new ArrayList<>();
	    	
	    	Customer cust = new Customer();
	    	cust.setTitle("Mr");
	    	cust.setName("Nipho");
	    	cust.setSurname("King");
	    	cust.setDate_of_birth("1990/05/05");
	    	cust.setCellnumber("089876543");
	    	cust.setEmail("nipho@kwal.com");
	    	cust.setProduct("Call of Duty");
	    	
	    	customers.add(cust);
	    	
		}
	    
	    public List<Customer> getAllUsers(){
	    	//Does some quesry to get all customers from database
	        return customers;
	     }
	    
	    public boolean addCustomer(Customer pCustomer) {
	    	
	    	//Add to database if customer does not exist
	    	//check if exist from database
	    	List<Customer> CustomerList = getAllUsers();
	    	
	        boolean userExists = false;
	        for(Customer customer: CustomerList){
	        	
	           if(customer.getName().equalsIgnoreCase(pCustomer.getName())){
	              userExists = true;
	              System.out.println("User Exist");
	              break;
	           }
	        }
	        
	        if(userExists != true){
	        	
	        	customers.add(pCustomer);
	        	//true saved
	           return true;
	        }
	        //false not saved
	        return false;
	    }
	    
	    

}

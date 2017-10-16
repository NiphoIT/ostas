package com.satso.nhl.SatsoAssess;


import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("customer")
public class CustomerResources {

	CustomerRepository customerRepo = new CustomerRepository();
	MessageStatus message = new MessageStatus();
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public MessageStatus getAliens(Customer customer) {
		
		Boolean isSaved = customerRepo.addCustomer(customer); 
		
		if(isSaved == true) {
			message.setStatus("successful");
			message.setMessage("Customer saved in the system");
			return message;
		}else {
			message.setStatus("failed");
			message.setMessage("Sorry customer already exist in the sytem");
			return message;
		}
	}
	
	
}

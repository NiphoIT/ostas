package com.satso.nhl.SatsoAssess;


import java.util.LinkedList;



import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("product")
public class ProductResource {
	
	ProductRepository productRepo = new ProductRepository();
	
	
	@GET
	@Path("/{value}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public LinkedList<Product> getProduct(@PathParam("value") String pName){
		System.out.println("Product called");
		return productRepo.getProducts(pName);
	}

}

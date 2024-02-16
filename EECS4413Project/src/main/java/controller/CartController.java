package controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import model.EcommerceModel;

@Path("cart") //this is the path of the resource
public class CartController {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getCart() throws Exception {
		return EcommerceModel.getInstance().populateCartView();
	}
	
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	public void addToCart(@QueryParam("bid") String bid) throws Exception {
		EcommerceModel.getInstance().addToCart(bid);		
	}
	
	@DELETE
	@Consumes(MediaType.TEXT_PLAIN)
	public void removeFromCart(@QueryParam("bid")String bid) throws Exception {
		EcommerceModel.getInstance().removeFromCart(bid);
	} 
}

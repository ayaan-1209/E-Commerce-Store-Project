package controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import model.EcommerceModel;

@Path("authentic") //this is the path of the resource
public class UserController {
	/*
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	public void writeReview(@QueryParam("username") String username, @QueryParam("password") String password,
			@QueryParam("fname") String fname, @QueryParam("lname")String lname, @QueryParam("phone")String phonenumber, 
			@QueryParam("email") String email, @QueryParam(")String street, String country, String zip) throws Exception {
		EcommerceModel.getInstance().registerUser(username, password, username, username, password, password, password, username, password);		
	}
	*/
}

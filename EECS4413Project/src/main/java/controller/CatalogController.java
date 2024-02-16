package controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import model.EcommerceModel;


@Path("catalog") //this is the path of the resource
public class CatalogController {

	@GET
	@Path("filter")
	@Produces(MediaType.APPLICATION_JSON)
	public String getCatalog(@QueryParam("apple") boolean apple, @QueryParam("samsung") boolean samsung, 
			@QueryParam("phone") boolean phone, @QueryParam("laptop") boolean laptop) throws Exception {
		return EcommerceModel.getInstance().filter(apple, samsung, phone, laptop);
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getCatalog() throws Exception {
		return EcommerceModel.getInstance().populateCatalog();
	}
	
	
}

package controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import model.EcommerceModel;


@Path("reviews") //this is the path of the resource
public class ReviewController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getReviews(@QueryParam("bid") String bid) throws Exception {
		return EcommerceModel.getInstance().getReviews(bid);
	}
	
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	public void writeReview(@QueryParam("review") String review, @QueryParam("rating") int rating, 
			@QueryParam("bid") String bid) throws Exception {
		EcommerceModel.getInstance().writeReview(review, rating, bid);		
	}
	
}
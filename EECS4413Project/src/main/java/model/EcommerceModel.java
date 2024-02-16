package model;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;

import com.google.gson.Gson;

import dao.CatalogDAO;
import dao.ConnectionDAO;
import dao.PoDAO;
import dao.ReviewsDAO;
import dao.ShoppingCartDAO;
import dao.UserDAO;
import dao.VisitEventDAO;

public class EcommerceModel {
	private static EcommerceModel instance;
	private Catalog cat;
	private ShoppingCart cart;
	private Reviews reviews;
	private VisitEvents events;
	private PurchaseOrders orders;
	private ConnectionDAO con;
	private CatalogDAO catalogData;
	private ShoppingCartDAO cartData;
	private ReviewsDAO reviewsData;
	private UserDAO userData;
	private VisitEventDAO eventsData;
	private PoDAO orderData;
	
	public static EcommerceModel getInstance() throws ClassNotFoundException{
		if (instance==null) {
			instance = new EcommerceModel();
			instance.cat = new Catalog();
			instance.cart = new ShoppingCart();
			instance.reviews = new Reviews();
			instance.events = new VisitEvents();
			instance.orders = new PurchaseOrders();
			instance.con = new ConnectionDAO();
			instance.catalogData = new CatalogDAO(instance.con.ds);
			instance.cartData = new ShoppingCartDAO(instance.con.ds);
			instance.reviewsData = new ReviewsDAO(instance.con.ds);
			instance.userData = new UserDAO(instance.con.ds);
			instance.eventsData = new VisitEventDAO(instance.con.ds);
			instance.orderData = new PoDAO(instance.con.ds);
		}
		return instance;
	}
	public EcommerceModel() {}
	
	public String populateCatalog() throws SQLException {
		cat.reset();
		return catalogData.populateCatalog(cat);
	}
	public void addToCart(String bid) throws SQLException {
		cartData.addToCart(cart, bid);
	}
	public String populateCartView() throws SQLException {
		Gson gson = new Gson();
		return gson.toJson(cart);
	}
	public void removeFromCart(String bid) {
		cart.removeItem(bid);
	}
	public void checkOut() throws SQLException {
		cart.checkOut(); 
		cartData.checkOut(cart);
	}
	public String getReviews(String bid) throws Exception {
		reviews.reset();
		return reviewsData.getReviewsJson(bid, reviews);
	}
	public void writeReview(String review, int rating, String bid) throws SQLException {
		String username = "Anonymous";
		if(this.userData.loggedIn) {
			username = this.userData.username;
		}
		reviewsData.writeReview(username, review, rating, bid);
	}
	public String filter(boolean apple, boolean samsung, boolean phone, boolean laptop) {
		Gson gson = new Gson();
		return gson.toJson(cat.filter(apple, samsung, phone, laptop));
	}

	public void registerUser(String username, String password, String fname, String lname, String phonenumber, String email, 
			String street, String country, String zip) throws NoSuchAlgorithmException, InvalidKeySpecException, SQLException {
		userData.registerUser(username, password, fname,lname, phonenumber, email, street, country, zip);
	}
	
	public boolean loginUser(String username, String password) throws NoSuchAlgorithmException, InvalidKeySpecException, SQLException {
		return userData.passwordMatch(username, password);
	}
	public String getVisitEvents() throws SQLException {
		return eventsData.getVisitEvents(events);
	}
	public void addVisitEvent(String ipAdress, String day, String bid, String eventType) throws SQLException {
		eventsData.addVisitEvent(ipAdress, day, bid, eventType);
	}
	public void addPO(String lname, String fname, String status, int address) throws SQLException {
		orderData.addPO(lname, fname, status, address);
	}
	public String getPurchaseOrders() throws SQLException {
		return orderData.getPurchaseOrders(orders);
	}
}

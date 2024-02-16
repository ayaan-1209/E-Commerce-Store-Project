package bean;

import java.io.Serializable;
import java.util.Date;

public class ReviewBean implements Serializable {	
	private static final long serialVersionUID = 1L;
	
	// Maybe we should change these to regular fields with getters/setters
	public static final int MAX_RATING = 5;
	public static final int MIN_RATING = 1;
	public static final int REVIEW_MAX_LENGTH_CHARS = 500;
	
	// This should be changed to a user object when we implement login/register
	private String username;
	private Date date;
	private int rating;
	private String reviewText;
	private String bid;
	
	public ReviewBean() {
		// TODO Auto-generated constructor stub
	}
	
	public ReviewBean(String user, int rating, String reviewText, String bid) throws Exception {
		// TODO Change to user object
		username = user;
		
		// Set the current date and time
		date = new Date();
		
		this.rating = validateRating(rating);
		this.reviewText = validateReviewText(reviewText);;
	}
	
	int validateRating(int rating) throws Exception {
		if (rating < MIN_RATING || rating > MAX_RATING) {
			throw new Exception("Rating is outside the allowed range!");
		}
		
		return rating;
	}
	
	String validateReviewText(String reviewText) throws Exception {
		if (reviewText.length() > REVIEW_MAX_LENGTH_CHARS) {
			throw new Exception("Review is too long!");
		}
		
		return reviewText;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		try {
			this.rating = validateRating(rating);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getReviewText() {
		return reviewText;
	}

	public void setReviewText(String reviewText) {
		try {
			this.reviewText = validateReviewText(reviewText);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

}
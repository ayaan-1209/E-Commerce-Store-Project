package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.google.gson.Gson;

import bean.ItemBean;
import bean.ReviewBean;
import model.Reviews;

public class ReviewsDAO {
	public DataSource ds;

	public ReviewsDAO(DataSource ds) {
		this.ds = ds;
	}
	public void writeReview(String username, String review, int rating, String bid) throws SQLException {
		String query2 = "INSERT INTO Review (username, review, rating, bid) VALUES (?,?,?,?)";
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query2);
		p.setString(1, username);
		p.setString(2, review);
		p.setInt(3, rating);
		p.setString(4, bid);
		p.execute();
	}
	
	public String getReviewsJson(String bid, Reviews reviews) throws Exception {
	
		String query = "SELECT * FROM Review where bid = '"+bid+"'";
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet rs = p.executeQuery();
		 while(rs.next()) {
			String bid1 = rs.getString("bid");
			String user = rs.getString("username");
			String review = rs.getString("review");
			int rating = rs.getInt("rating");
			ReviewBean item = new ReviewBean(user, rating, review, bid1);
			reviews.addItem(item);
		 }
		 reviews.updateAverageRating();
		 reviews.updateNumOfReviews();
		 Gson gson = new Gson();
		 return gson.toJson(reviews);
	}
}

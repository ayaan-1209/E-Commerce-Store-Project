package model;

import java.util.ArrayList;

import bean.ReviewBean;

public class Reviews {
	ArrayList<ReviewBean> reviews = new ArrayList<>();
	int numberOfReviews;
	double averageRating;
	
	public Reviews(){}
	public void reset() {
		reviews = new ArrayList<>();
	}
	public void addItem(ReviewBean review) {
		reviews.add(review);
	}
	
	public void removeItem(ReviewBean review) {
		reviews.remove(review);
	}
	public void updateNumOfReviews() {
		numberOfReviews = reviews.size();
	}
	public void updateAverageRating() {
		double totalRating = 0;
		for(ReviewBean review: reviews) {
			totalRating+=review.getRating();
		}
		if(reviews.size() == 0) 
			averageRating = 0;
		else
			averageRating = (Math.round(totalRating*100.0)/100.0)/reviews.size();
	}
}

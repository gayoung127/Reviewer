package com.reviewer.mvc.model.dto;

public class Review {

	private int reviewId;
	private String foodName;
	private String foodComent;
	private int foodRating;
	private int boardId;
	
	public Review() {
	}

	public Review(int reviewId, String foodName, String foodComent, int foodRating, int boardId) {
		this.reviewId = reviewId;
		this.foodName = foodName;
		this.foodComent = foodComent;
		this.foodRating = foodRating;
		this.boardId = boardId;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getFoodComent() {
		return foodComent;
	}

	public void setFoodComent(String foodComent) {
		this.foodComent = foodComent;
	}

	public int getFoodRating() {
		return foodRating;
	}

	public void setFoodRating(int foodRating) {
		this.foodRating = foodRating;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", foodName=" + foodName + ", foodComent=" + foodComent
				+ ", foodRating=" + foodRating + ", boardId=" + boardId + "]";
	}

}

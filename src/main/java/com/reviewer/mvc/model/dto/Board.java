package com.reviewer.mvc.model.dto;

public class Board {

	private int boardId; //auto
	private String title;
	private String restaurant;
	private String coment;
	private double reviewRating; //auto
	private int viewCnt = 0; //auto
	private String regDate; //auto
	private String writer; //session에서 불러오기
	
	public Board() {
	}

	public Board(int boardId, String title, String restaurant, String coment, double reviewRating, int viewCnt,
			String regDate, String writer) {
		this.boardId = boardId;
		this.title = title;
		this.restaurant = restaurant;
		this.coment = coment;
		this.reviewRating = reviewRating;
		this.viewCnt = viewCnt;
		this.regDate = regDate;
		this.writer = writer;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}

	public String getComent() {
		return coment;
	}

	public void setComent(String coment) {
		this.coment = coment;
	}

	public double getReviewRating() {
		return reviewRating;
	}

	public void setReviewRating(double reviewRating) {
		this.reviewRating = reviewRating;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	@Override
	public String toString() {
		return "Board [boardId=" + boardId + ", title=" + title + ", restaurant=" + restaurant + ", coment=" + coment
				+ ", reviewRating=" + reviewRating + ", viewCnt=" + viewCnt + ", regDate=" + regDate + ", writer="
				+ writer + "]";
	}
	
}

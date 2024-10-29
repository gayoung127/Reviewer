package com.reviewer.mvc.model.service;

import java.util.List;

import com.reviewer.mvc.model.dto.Review;

public interface ReviewService {

	List<Review> getReviewsById(int boardId);

	void writeReview(Review review);

}

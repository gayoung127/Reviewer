package com.reviewer.mvc.model.service;

import java.util.List;

import com.reviewer.mvc.model.dto.Review;
import com.reviewer.mvc.model.dto.ReviewWrapper;

public interface ReviewService {

	List<Review> getReviewsById(int boardId);

	void writeReview(Review review);

	void deleteByBoardId(int id);

	void updateReviews(int boardId, List<Review> updateReviews);

}

package com.reviewer.mvc.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.reviewer.mvc.model.dao.ReviewDao;
import com.reviewer.mvc.model.dto.Review;

@Service
public class ReviewServiceImpl implements ReviewService{
	
	private final ReviewDao reviewDao;
	
	public ReviewServiceImpl(ReviewDao reviewDao) {
		this.reviewDao = reviewDao;
	}

	@Override
	public List<Review> getReviewsById(int boardId) {
		return reviewDao.selectById(boardId);
	}

	@Override
	public void writeReview(Review review) {
		reviewDao.insert(review);
	}

}

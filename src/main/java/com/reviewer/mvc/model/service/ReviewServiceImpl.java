package com.reviewer.mvc.model.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.reviewer.mvc.model.dao.ReviewDao;
import com.reviewer.mvc.model.dto.Review;

@Service
public class ReviewServiceImpl implements ReviewService {

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

	@Override
	public void deleteByBoardId(int id) {
		reviewDao.deleteByBoardId(id);
	}

	@Override
	public void updateReviews(int boardId, List<Review> updateReviews) {
		List<Review> existReviews = reviewDao.selectById(boardId);
		
		//기존 리뷰들 id 목록을 추출
		Set<Integer> existReviewIds = existReviews.stream().map(Review::getReviewId).collect(Collectors.toSet());
		//업데이트할 리뷰 id 목록 추출
		Set<Integer> updateReviewIds = updateReviews.stream().map(Review::getReviewId).collect(Collectors.toSet());
		//삭제할 리뷰 id 계산
		Set<Integer> deleteReviewsIds = new HashSet<>(existReviewIds);
		deleteReviewsIds.removeAll(updateReviewIds); //삭제해야할 리뷰아이디만 남아있게 됨
		for(int reviewId : deleteReviewsIds) {
			reviewDao.deleteByReviewId(reviewId);
		}
		
		for(Review review : updateReviews) {
			review.setBoardId(boardId);
			if(review.getReviewId() == null) {
				reviewDao.insert(review);
			} else {
				reviewDao.update(review);
			}
		}
	}

}

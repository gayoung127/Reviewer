package com.reviewer.mvc.model.dao;

import java.util.List;

import com.reviewer.mvc.model.dto.Review;

public interface ReviewDao {

	List<Review> selectById(int boardId);

	void insert(Review review);

	void deleteByBoardId(int id);

	void deleteByReviewId(int id);

	void update(Review review);

}

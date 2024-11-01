package com.reviewer.mvc.model.dao;

import java.util.List;

import com.reviewer.mvc.model.dto.Board;

public interface BoardDao {

	List<Board> selectAll();

	Board selectById(int id);

	void insert(Board board);

	void delete(int id);

	void update(Board board);

}

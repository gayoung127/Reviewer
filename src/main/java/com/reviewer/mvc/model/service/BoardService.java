package com.reviewer.mvc.model.service;

import java.util.List;

import com.reviewer.mvc.model.dto.Board;

public interface BoardService {

	List<Board> selectAll();

	Board getBoardByid(int id);

	void writeBoard(Board board);

}

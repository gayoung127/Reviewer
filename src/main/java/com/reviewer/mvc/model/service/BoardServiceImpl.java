package com.reviewer.mvc.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.reviewer.mvc.model.dao.BoardDao;
import com.reviewer.mvc.model.dto.Board;

@Service
public class BoardServiceImpl implements BoardService{
	
	private final BoardDao boardDao;
	
	public BoardServiceImpl(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	@Override
	public List<Board> selectAll() {
		return boardDao.selectAll();
	}

	@Override
	public Board getBoardByid(int id) {
		return boardDao.selectById(id);
	}

	@Override
	public void writeBoard(Board board) {
		boardDao.insert(board);
	}

}

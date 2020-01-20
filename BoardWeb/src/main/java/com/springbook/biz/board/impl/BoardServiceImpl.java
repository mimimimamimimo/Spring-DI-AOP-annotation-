package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.common.Log4Advice;
import com.springbook.biz.common.LogAdvice;

@Service("boardService")  //id는 대부분 클래스앞글자 소문자로 해서 쓴다
public class BoardServiceImpl implements BoardService {

	@Autowired   //빈에 다 등록되있으니 굳이 new 할 필요가 없다 자동주입! 자동주입이유는 코드간결성뿐만 아니라 xml부담감소도 있다그랬지!
	private BoardDAO boardDAO;
	//private Log4Advice log;
	
	BoardServiceImpl(){
		//log=new Log4Advice();
	}
	@Override
	public void insertBoard(BoardVO vo) {
		
		//log.printLogging();
		boardDAO.insertBoard(vo);
	}

	@Override
	public void updatetBoard(BoardVO vo) {
		
		//log.printLogging();
		boardDAO.updatetBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		
		//log.printLogging();
		boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		
		//log.printLogging();
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		
		//log.printLogging();
		return boardDAO.getBoardList(vo);
		
	}

}

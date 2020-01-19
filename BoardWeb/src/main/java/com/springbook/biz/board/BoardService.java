package com.springbook.biz.board;

import java.util.List;

public interface BoardService {//이 인터페이스는 BoardDAO에서 추출(shft+alt+T)한 것이다. 하지만 정작 BoardDAO는 이 인터페이스를 상속받지 않는다.
	                           //why?dao는 Board에만 한정해서 쓰는게 아닌기 때문에 독립적으로 존재해야 한다

	void insertBoard(BoardVO vo);    //오호 주석도 같이 추출되네~~
    
	//글 수정
	void updatetBoard(BoardVO vo);

	//글 삭제
	void deleteBoard(BoardVO vo);

	//글 상세조회
	BoardVO getBoard(BoardVO vo);

	//글목록조회
	List<BoardVO> getBoardList(BoardVO vo);

}
package com.springbook.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.common.JDBCUtil;

@Repository("BoardDAO")  //dao 빈을 등록(component로 해도 되긴됨)
public class BoardDAO{
	//jdbc관련 변수
	private Connection conn=null;
	private PreparedStatement stmt=null;  //?
	private ResultSet rs=null;    //결과
	
	
	//사용할 쿼리들
	private final String BOARD_INSERT="insert into board(seq,title,writer,content) values((select nvl(max(seq),0)+1 from board),?,?,?)";
	private final String BOARD_UPDATE="update board set title=?,content=? where seq=?";
	private final String BOARD_DELETE="delete board where seq=?";
	private final String BOARD_GET="select * from board where seq=?";
	private final String BOARD_LIST="select * from board order by seq desc";
	
	//crud메소드구현
	//글등록
	
	/* (non-Javadoc)
	 * @see com.springbook.biz.board.impl.BoardService#insertBoard(com.springbook.biz.board.BoardVO)
	 */
	public void insertBoard(BoardVO vo) {
		System.out.println("jdbc로 insert기능처리");
		
		try {  
			conn=JDBCUtil.getConnection();
			stmt=conn.prepareStatement(BOARD_INSERT);    //쿼리 정하고
			stmt.setString(1,vo.getTitle());  //물음표에 넣을 인자 정해서
			stmt.setString(2,vo.getWriter());
			stmt.setString(3,vo.getContent());
			stmt.executeUpdate();  //쿼리 실행
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {  //마찬가지로 예외처리와 파이널처리는 해준다.
			JDBCUtil.close(stmt, conn);
		}
	}
	//글 수정
	/* (non-Javadoc)
	 * @see com.springbook.biz.board.impl.BoardService#updatetBoard(com.springbook.biz.board.BoardVO)
	 */
	public void updatetBoard(BoardVO vo) {
		System.out.println("jdbc로 update기능처리");
		
		try {
			conn=JDBCUtil.getConnection();
			stmt=conn.prepareStatement(BOARD_UPDATE);
			stmt.setString(1,vo.getTitle());

			stmt.setString(2,vo.getContent());
			
			stmt.setInt(3, vo.getSeq());
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	//글 삭제
		/* (non-Javadoc)
		 * @see com.springbook.biz.board.impl.BoardService#deleteBoard(com.springbook.biz.board.BoardVO)
		 */
		public void deleteBoard(BoardVO vo) {
			System.out.println("jdbc로 delete기능처리");
			
			try {
				conn=JDBCUtil.getConnection();
				stmt=conn.prepareStatement(BOARD_DELETE);
				stmt.setInt(1, vo.getSeq());
				stmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(stmt, conn);
			}
		}

	//글 상세조회
		/* (non-Javadoc)
		 * @see com.springbook.biz.board.impl.BoardService#getBoard(com.springbook.biz.board.BoardVO)
		 */
		public BoardVO getBoard(BoardVO vo) {
			System.out.println("jdbc로 getBoard기능처리");
			BoardVO board=null;
			try {
				conn=JDBCUtil.getConnection();
				stmt=conn.prepareStatement(BOARD_GET);
				stmt.setInt(1, vo.getSeq());
				rs=stmt.executeQuery();
				if(rs.next()) {
					board=new BoardVO();
					board.setSeq(rs.getInt("SEQ"));
					board.setTitle(rs.getString("TITLE"));
					board.setWriter(rs.getString("WRITER"));
					board.setContent(rs.getString("CONTENT"));
					board.setCnt(rs.getInt("CNT"));
				
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(rs,stmt, conn);
			}
			return board;
		}
	
	//글목록조회
		/* (non-Javadoc)
		 * @see com.springbook.biz.board.impl.BoardService#getBoardList(com.springbook.biz.board.BoardVO)
		 */
		public List<BoardVO> getBoardList(BoardVO vo) {
			System.out.println("jdbc로 getBoardList기능처리");
			List<BoardVO> boardlist=new ArrayList<BoardVO>();
			
			try {
				conn=JDBCUtil.getConnection();
				stmt=conn.prepareStatement(BOARD_LIST);
				rs=stmt.executeQuery();
				while(rs.next()) {
					BoardVO board=new BoardVO();
	
					board.setSeq(rs.getInt("SEQ"));
					board.setTitle(rs.getString("TITLE"));
					board.setWriter(rs.getString("WRITER"));
					board.setContent(rs.getString("CONTENT"));
					board.setRegDate(rs.getDate("REGDATE"));
					board.setCnt(rs.getInt("CNT"));
					boardlist.add(board);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(rs,stmt, conn);
			}
			return boardlist;
		}
	
			
}

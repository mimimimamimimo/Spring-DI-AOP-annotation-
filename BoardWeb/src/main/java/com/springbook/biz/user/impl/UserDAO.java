package com.springbook.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.common.JDBCUtil;
import com.springbook.biz.user.UserVO;

@Repository("userDAO")
public class UserDAO{  //얘는 왜 static아닐까, 여러 서비스에서 갖다쓰는데 한 커넥션으로 안되서?
	private Connection conn=null;
	private PreparedStatement stmt=null;  //?
	private ResultSet rs=null; 
	
	private final String USER_GET="select * from users where id=? and password=?";
	//역시 ??부분은 뒤에서 설정하는게 맞았당
	/* (non-Javadoc)
	 * @see com.springbook.biz.user.impl.UserService#getUser(com.springbook.biz.user.UserVO)
	 */
	
	public UserVO getUser(UserVO vo) {  //왜 문자열 아닌 몇개 초기값인 객체로 받는가 했더니
		System.out.println("jdbc로 getUser기능처리");  //해당 객체의 일부칼럼으로 검색을 할거기때문
		UserVO user=null;
		try {
			conn=JDBCUtil.getConnection();
			stmt=conn.prepareStatement(USER_GET);
			stmt.setString(1, vo.getId());   //sql문 ??부분 완성하고
			stmt.setString(2, vo.getPassword());  //실행
			rs=stmt.executeQuery();
			if(rs.next()) {
				user=new UserVO();  //새 객체로 변환해서 돌려줘야 함
				user.setId(rs.getString("ID"));
				user.setRole(rs.getString("ROLE"));
				user.setName(rs.getString("NAME"));
				user.setPassword(rs.getString("PASSWORD"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs,stmt, conn);
		}
		return user;
	}
}

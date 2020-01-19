package com.springbook.biz.common;

import java.sql.Connection;
import java.sql.DriverManager;  //sql꺼랑 딴거랑 뭔차이지
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCUtil {  //당분간 db는 jdbc로 할거라서, 모든 dao에서 사용할 db연동처리를 이 클래스로 작성
	public static Connection getConnection() {  //연결 ...static인 이유는 하나만 있으면 되서인가
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","chaeeun","6657");  //여기 수정해야
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void close(PreparedStatement stmt,Connection conn) {  //해제 
		try {
			if(!stmt.isClosed()) stmt.close();
			
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}finally {
			stmt=null;
		}
		
		if(conn!=null) {
			try {
				if(!conn.isClosed()) conn.close();
			} catch (Exception e) {   //항상 예외처리와 finall 마무리는 하는구나
				e.printStackTrace();
				// TODO: handle exception
			}finally {
				conn=null;
			}
		}
	}
	
	public static void close(ResultSet rs,PreparedStatement stmt,Connection conn) {  //close는 오버로딩되서 다양하게 가질수있음
		if(rs!=null) {
			try {
				if(!rs.isClosed()) rs.close();
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}finally {
				rs=null;
			}
		}
		
		if(stmt!=null) {
			try {
				if(!stmt.isClosed()) stmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				stmt=null;
			}
			
			if(conn!=null) {
				try {
					if(!conn.isClosed()) conn.close();
				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}finally {
					conn=null;
				}
			}
		}
	}
}

package com.springbook.biz.board;

import java.util.Date;

public class BoardVO {  //VO==DTO(데이터 전달 목적), db 칼럼과 같게, source-code generate로 getter setter 구현. 

	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date regDate;  //
	private int cnt;
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	@Override //아하 이때까지 값나오는거 모두 오버라이드해서 쓴거구나..
	public String toString(){
		return "BoardVO [seq="+seq+" title= "+title+"writer= "+writer+"content= "+content+"regDate "+regDate+"cnt="+cnt+"]";
	}
}

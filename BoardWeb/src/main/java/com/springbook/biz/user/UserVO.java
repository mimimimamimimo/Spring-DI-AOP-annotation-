package com.springbook.biz.user;
//..으로 나뉘는 패키지가 상위꺼에 클래스 없으면 안만들어지는구나

public class UserVO {
	private String id;
	private String password;
	private String name;
	private String role;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	@Override
	public String toString() {
		return "UserVO id="+id+"password="+password+"name="+name+"role="+role+"]";
	}
	
}

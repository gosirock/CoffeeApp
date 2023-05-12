package com.javalec.dto;

public class Hsh_logindto {
	String uid;
	String upssword;
	public Hsh_logindto(String uid, String upssword) {
		super();
		this.uid = uid;
		this.upssword = upssword;
	}
	
	public Hsh_logindto() {
		// TODO Auto-generated constructor stub
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUpssword() {
		return upssword;
	}

	public void setUpssword(String upssword) {
		this.upssword = upssword;
	}
	
}


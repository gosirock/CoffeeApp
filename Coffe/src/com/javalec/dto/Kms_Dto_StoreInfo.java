package com.javalec.dto;

public class Kms_Dto_StoreInfo {
	
	String sname;
	String opentime;
	String closetime;
	String telno;
	String address;
	String cnum;
	
	public String getCnum() {
		return cnum;
	}

	
	public void setCnum(String cnum) {
		this.cnum = cnum;
	}

	public Kms_Dto_StoreInfo() {
		// TODO Auto-generated constructor stub
	}
	

	public Kms_Dto_StoreInfo(String sname, String cnum, String opentime, String closetime, String telno, String address) {
		super();
		this.sname = sname;
		this.cnum = cnum;
		this.opentime = opentime;
		this.closetime = closetime;
		this.telno = telno;
		this.address = address;
	}


	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getOpentime() {
		return opentime;
	}

	public void setOpentime(String opentime) {
		this.opentime = opentime;
	}

	public String getClosetime() {
		return closetime;
	}

	public void setClosetime(String closetime) {
		this.closetime = closetime;
	}

	public String getTelno() {
		return telno;
	}

	public void setTelno(String telno) {
		this.telno = telno;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	

}

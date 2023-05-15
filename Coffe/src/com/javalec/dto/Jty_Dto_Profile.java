package com.javalec.dto;

public class Jty_Dto_Profile {
	
	String cid;
	String cpassword;
	String cname;
	String cphone;
	String cemail;
	String caddress;
	String paymentPassword;
	String cinsertdate;
	
	// 프로필 오픈시
	public Jty_Dto_Profile(String cid, String cpassword, String cname, String cphone, String cemail, String caddress,
			String paymentPassword, String cinsertdate) {
		super();
		this.cid = cid;
		this.cpassword = cpassword;
		this.cname = cname;
		this.cphone = cphone;
		this.cemail = cemail;
		this.caddress = caddress;
		this.paymentPassword = paymentPassword;
		this.cinsertdate = cinsertdate;
	}
	
	
	// 프로필 업데이트
	public Jty_Dto_Profile(String cname, String cid, String cpassword, String cphone, String cemail, String caddress) {
		super();
		this.cname = cname;
		this.cid = cid;
		this.cpassword = cpassword;
		this.cphone = cphone;
		this.cemail = cemail;
		this.caddress = caddress;
	}



	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCpassword() {
		return cpassword;
	}

	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}

	public String getCphone() {
		return cphone;
	}

	public void setCphone(String cphone) {
		this.cphone = cphone;
	}

	public String getCemail() {
		return cemail;
	}

	public void setCemail(String cemail) {
		this.cemail = cemail;
	}

	public String getCaddress() {
		return caddress;
	}

	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}

	public String getPaymentPassword() {
		return paymentPassword;
	}

	public void setPaymentPassword(String paymentPassword) {
		this.paymentPassword = paymentPassword;
	}
	
	public String getCinsertdate() {
		return cinsertdate;
	}
	
	public void setCinsertdate(String cinsertdate) {
		this.cinsertdate = cinsertdate;
	}
	
	

}

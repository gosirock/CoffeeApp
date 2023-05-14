package com.javalec.dto;

import java.sql.Date;

public class DtoCoupon_kwh {
	int discount;
	String customer_cid;
	Date cpinsertdate;
	int cUse;
	
	public DtoCoupon_kwh() {
		// TODO Auto-generated constructor stub
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getCustomer_cid() {
		return customer_cid;
	}

	public void setCustomer_cid(String customer_cid) {
		this.customer_cid = customer_cid;
	}

	public Date getCpinsertdate() {
		return cpinsertdate;
	}

	public void setCpinsertdate(Date cpinsertdate) {
		this.cpinsertdate = cpinsertdate;
	}

	public int getcUse() {
		return cUse;
	}

	public void setcUse(int cUse) {
		this.cUse = cUse;
	}
	
	
	
	
	

}

package com.javalec.dto;

import java.sql.Date;

public class Kms_Dto_StoreSales {

	int seqno;
	Date date;
	int price;
	
	public Kms_Dto_StoreSales() {
		// TODO Auto-generated constructor stub
	}

	
	public Kms_Dto_StoreSales(int seqno, Date date, int price) {
		super();
		this.seqno = seqno;
		this.date = date;
		this.price = price;
	}


	public int getSeqno() {
		return seqno;
	}

	public void setSeqno(int seqno) {
		this.seqno = seqno;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}

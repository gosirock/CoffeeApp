package com.javalec.dto;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;

public class DtoReview_kwh {

	String iid;
	String cid;
	String title;
	String comment;
	String rimagename="";
	Date rinsertdate;
	
	String iname;
	int iprice;
	
	// File
	FileInputStream rimage;
	InputStream image;
	
	
	public DtoReview_kwh() {
		// TODO Auto-generated constructor stub
	}


	
	
	
	
	
	
	
	
	
	

	public String getIid() {
		return iid;
	}



	//리뷰확인란 데이터넣기위한 생성자
	public DtoReview_kwh(String cid, String iname, int iprice, String title, String comment, String rimagename,  InputStream image, Date rinsertdate	) {
		super();
		this.cid = cid;
		this.title = title;
		this.comment = comment;
		this.rimagename = rimagename;
		this.rinsertdate = rinsertdate;
		this.iname = iname;
		this.iprice = iprice;
		this.rimage = rimage;
	}


	public void setIid(String iid) {
		this.iid = iid;
	}



	public String getCid() {
		return cid;
	}



	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getIname() {
		return iname;
	}
	
	
	
	public void getIname(String iname) {
		this.iname = iname;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getComment() {
		return comment;
	}



	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getPprice() {
		return iprice;
	}
	
	
	
	public void getPprice(int pprice) {
		this.iprice = iprice;
	}



	public String getRimagename() {
		return rimagename;
	}



	public void setRimagename(String rimagename) {
		this.rimagename = rimagename;
	}



	public Date getRinsertdate() {
		return rinsertdate;
	}



	public void setRinsertdate(Date rinsertdate) {
		this.rinsertdate = rinsertdate;
	}
	
	
	
	
}

package com.javalec.dto;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;

public class DtoReview_kwh {

	String item_iid;
	String customer_cid;
	String title;
	String comment;
	String rimagename="";
	Date rinsertdate;
	
	String iname;
	int iprice;
	int iCount;
	
	// File
	FileInputStream rimage;
	InputStream image;
	
	
	public DtoReview_kwh() {
		// TODO Auto-generated constructor stub
	}


	
	
	
	
	
	
	
	
	
	

	


	//리뷰확인란 데이터넣기위한 생성자
	public DtoReview_kwh(String customer_cid, String iname, int iprice, String title, String comment, String rimagename,  InputStream image, Date rinsertdate	) {
		super();
		this.customer_cid = customer_cid;
		this.title = title;
		this.comment = comment;
		this.rimagename = rimagename;
		this.rinsertdate = rinsertdate;
		this.iname = iname;
		this.iprice = iprice;
		this.rimage = rimage;
	}

	
	















	public DtoReview_kwh(String iname, int iCount) {
		super();
		this.iname = iname;
		this.iCount = iCount;
	}
















	public DtoReview_kwh(String customer_cid, String iname, int iprice,String title, String comment, String rimagename, Date rinsertdate) {
		super();
		this.customer_cid = customer_cid;
		this.title = title;
		this.comment = comment;
		this.rimagename = rimagename;
		this.rinsertdate = rinsertdate;
		this.iname = iname;
		this.iprice = iprice;
	}
















	public int getiCount() {
		return iCount;
	}
















	public void setiCount(int iCount) {
		this.iCount = iCount;
	}
















	public String getItem_iid() {
		return item_iid;
	}
















	public void setItem_iid(String item_iid) {
		this.item_iid = item_iid;
	}
















	public String getCustomer_cid() {
		return customer_cid;
	}
















	public void setCustomer_cid(String customer_cid) {
		this.customer_cid = customer_cid;
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
















	public String getIname() {
		return iname;
	}
















	public void setIname(String iname) {
		this.iname = iname;
	}
















	public int getIprice() {
		return iprice;
	}
















	public void setIprice(int iprice) {
		this.iprice = iprice;
	}
















	public FileInputStream getRimage() {
		return rimage;
	}
















	public void setRimage(FileInputStream rimage) {
		this.rimage = rimage;
	}
















	public InputStream getImage() {
		return image;
	}
















	public void setImage(InputStream image) {
		this.image = image;
	}


	
	
	
	
	
}

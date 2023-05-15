package com.javalec.dto;

import java.io.FileInputStream;

public class Kms_Dto_AdminProduct {

	String iid;
	String iname;
	int iprice;
	int istock;
	String iimagename;
	FileInputStream iimage;
	String idescription;
	
	public Kms_Dto_AdminProduct(String iid, String iname, int iprice, int istock) {
		super();
		this.iid = iid;
		this.iname = iname;
		this.iprice = iprice;
		this.istock = istock;
	}




	public Kms_Dto_AdminProduct(String iid, String iname, int iprice, int istock, String iimagename,
			String idescription) {
		super();
		this.iid = iid;
		this.iname = iname;
		this.iprice = iprice;
		this.istock = istock;
		this.iimagename = iimagename;
		this.idescription = idescription;
	}
	
	

	
	public Kms_Dto_AdminProduct(String iid, String iname, int iprice, int istock, FileInputStream iimage,
			String idescription) {
		super();
		this.iid = iid;
		this.iname = iname;
		this.iprice = iprice;
		this.istock = istock;
		this.iimage = iimage;
		this.idescription = idescription;
	}




	public Kms_Dto_AdminProduct(String iid, String iname, int iprice, int istock, String idescription) {
		super();
		this.iid = iid;
		this.iname = iname;
		this.iprice = iprice;
		this.istock = istock;
		this.idescription = idescription;
	}




	public Kms_Dto_AdminProduct() {
		// TODO Auto-generated constructor stub
	}

	public String getIid() {
		return iid;
	}

	public void setIid(String iid) {
		this.iid = iid;
	}

	public String getIimagename() {
		return iimagename;
	}

	public void setIimagename(String iimagename) {
		this.iimagename = iimagename;
	}

	public String getIdescription() {
		return idescription;
	}

	public void setIdescription(String idescription) {
		this.idescription = idescription;
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

	public int getIstock() {
		return istock;
	}

	public void setIstock(int istock) {
		this.istock = istock;
	}

	public FileInputStream getIimage() {
		return iimage;
	}

	public void setIimage(FileInputStream iimage) {
		this.iimage = iimage;
	}
	
	
}
package com.javalec.dto;

public class Lju_dto {

	
	
	
	String iid;
	String iname;
	int iprice;
	String iimagename;
	String idescription;
	int bqty;
	String pdate;
	int pqty;
	int psaleprice;
	int pSeq;
	
	




	public Lju_dto() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	public Lju_dto(String idescription, String iname, int iprice, String iimagename) {
		super();
		this.idescription = idescription;
		this.iname = iname;
		this.iprice = iprice;
		this.iimagename = iimagename;
	}





	public Lju_dto(String idescription, String iname, int iprice, String iimagename, String iid) {
		super();
		this.iid = iid;
		this.iname = iname;
		this.iprice = iprice;
		this.iimagename = iimagename;
		this.idescription = idescription;
	}



	public Lju_dto(String iname, int iprice, String iimagename, String iid, int bqty) {
		super();
		this.iid = iid;
		this.iname = iname;
		this.iprice = iprice;
		this.iimagename = iimagename;
		this.bqty = bqty;
	}





	public Lju_dto(String pdate, String iname, int pqty, int psaleprice, String iimagename)  {
		super();
		this.pdate = pdate;
		this.iname = iname;
		this.pqty = pqty;
		this.psaleprice = psaleprice;
		this.iimagename = iimagename;
	}





	public String getPdate() {
		return pdate;
	}





	public void setPdate(String pdate) {
		this.pdate = pdate;
	}





	public int getPqty() {
		return pqty;
	}





	public void setPqty(int pqty) {
		this.pqty = pqty;
	}





	public int getPsaleprice() {
		return psaleprice;
	}





	public void setPsaleprice(int psaleprice) {
		this.psaleprice = psaleprice;
	}





	public int getpSeq() {
		return pSeq;
	}





	public void setpSeq(int pSeq) {
		this.pSeq = pSeq;
	}





	public String getIid() {
		return iid;
	}





	public void setIid(String iid) {
		this.iid = iid;
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




	public String getIimagename() {
		return iimagename;
	}




	public void setIimagename(String iimagename) {
		this.iimagename = iimagename;
	}


	public int getBqty() {
		return bqty;
	}





	public void setBqty(int bqty) {
		this.bqty = bqty;
	}


	
}

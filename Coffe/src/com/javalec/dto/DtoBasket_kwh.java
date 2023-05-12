package com.javalec.dto;

public class DtoBasket_kwh {
	
	String ibid;
	String cbid;
	int bqty;
	String iid;
	String iname;
	int iprice;
	
	public DtoBasket_kwh() {
		// TODO Auto-generated constructor stub
	}

	public DtoBasket_kwh(String ibid, String cbid, int bqty) {
		super();
		this.ibid = ibid;
		this.cbid = cbid;
		this.bqty = bqty;
	}
	
	

	public DtoBasket_kwh( String iid, String iname, int iprice, int bqty) {
		super();
		this.bqty = bqty;
		this.iid = iid;
		this.iname = iname;
		this.iprice = iprice;
	}

	public String getIbid() {
		return ibid;
	}

	public void setIbid(String ibid) {
		this.ibid = ibid;
	}

	public String getCbid() {
		return cbid;
	}

	public void setCbid(String cbid) {
		this.cbid = cbid;
	}

	public int getBqty() {
		return bqty;
	}

	public void setBqty(int bqty) {
		this.bqty = bqty;
	}
	
	
	
	

}

package com.javalec.dto;

public class Jty_Dto_Help {
	
	String slocation;
	String stelno;
	String sopentime;
	String sclosetime;
	String sbusinessname;
	String scompanyno;
	
	public Jty_Dto_Help() {
		// TODO Auto-generated constructor stub
	}

	public Jty_Dto_Help(String slocation, String stelno, String sopentime, String sclosetime, String sbusinessname,
			String scompanyno) {
		super();
		this.slocation = slocation;
		this.stelno = stelno;
		this.sopentime = sopentime;
		this.sclosetime = sclosetime;
		this.sbusinessname = sbusinessname;
		this.scompanyno = scompanyno;
	}

	public String getSlocation() {
		return slocation;
	}

	public void setSlocation(String slocation) {
		this.slocation = slocation;
	}

	public String getStelno() {
		return stelno;
	}

	public void setStelno(String stelno) {
		this.stelno = stelno;
	}

	public String getSopentime() {
		return sopentime;
	}

	public void setSopentime(String sopentime) {
		this.sopentime = sopentime;
	}

	public String getSclosetime() {
		return sclosetime;
	}

	public void setSclosetime(String sclosetime) {
		this.sclosetime = sclosetime;
	}

	public String getSbusinessname() {
		return sbusinessname;
	}

	public void setSbusinessname(String sbusinessname) {
		this.sbusinessname = sbusinessname;
	}

	public String getScompanyno() {
		return scompanyno;
	}

	public void setScompanyno(String scompanyno) {
		this.scompanyno = scompanyno;
	}
	
	

}

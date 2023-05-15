package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;

import com.javalec.dto.Jty_Dto_Help;
import com.javalec.dto.Jty_Dto_Profile;
import com.javalec.util.ShareVar;

public class Jty_Dao_Help {
	
	String slocation;
	String stelno;
	String sopentime;
	String sclosetime;
	String sbusinessname;
	String scompanyno;
	
	private final String url_mysql = ShareVar.DBName;
	private final String id_mysql = ShareVar.DBUser;
	private final String pw_mysql = ShareVar.DBPass;
	
	public Jty_Dao_Help() {
		// TODO Auto-generated constructor stub
	}
	
	public Jty_Dao_Help(String slocation, String stelno, String sopentime, String sclosetime, String sbusinessname,
			String scompanyno) {
		super();
		this.slocation = slocation;
		this.stelno = stelno;
		this.sopentime = sopentime;
		this.sclosetime = sclosetime;
		this.sbusinessname = sbusinessname;
		this.scompanyno = scompanyno;
	}
	
	public Jty_Dto_Help openHelp() {
	    Jty_Dto_Help dto_help = null;
	    String query = "select slocation, stelno, sopentime, sclosetime, sbusinessname, scompanyno from store";

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
	        Statement stmt_mysql = conn_mysql.createStatement();

	        ResultSet rs = stmt_mysql.executeQuery(query);

	        while (rs.next()) {
	            String wkslocation = rs.getString(1);
	            String wkstelno = rs.getString(2);
	            String sopentime = rs.getString(3);
	            String sclosetime = rs.getString(4);
	            String wksbusinessname = rs.getString(5);
	            String wkscompanyno = rs.getString(6);

	

	            dto_help = new Jty_Dto_Help(wkslocation, wkstelno, sopentime, sclosetime, wksbusinessname, wkscompanyno);
	        }
	        conn_mysql.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return dto_help;
	}

}

package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.javalec.util.ShareVar;

public class Lju_BasketEmpty {

	
	private final String url_mysql = ShareVar.DBName;
	private final String id_mysql = ShareVar.DBUser;
	private final String pw_mysql = ShareVar.DBPass;
	public static String loginUserId = "";
	
	
	String iid;
	String cid;
	
	
	public Lju_BasketEmpty() {
		// TODO Auto-generated constructor stub
	}


	public Lju_BasketEmpty(String cid) {
		super();
		this.cid = cid;
	}


	public Lju_BasketEmpty(String iid, String cid) {
		super();
		this.iid = iid;
		this.cid = cid;
	}
	
	
	
	
	public void selectDelete() {
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			String cidd = cid;
			String query = "delete from basket where item_iid = '" + iid + "'";
			
			ps = conn_mysql.prepareStatement(query);
			ps.executeUpdate();
			conn_mysql.close();
			
		
	}catch(Exception e) {
		e.printStackTrace();
	}

	}
	
	
	
	
}

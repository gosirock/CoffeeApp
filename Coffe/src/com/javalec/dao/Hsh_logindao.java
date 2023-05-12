package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.javalec.util.ShareVar;

public class Hsh_logindao {
	private final String url_mysql = ShareVar.DBName;
	private final String id_mysql = ShareVar.DBUser;
	private final String pw_mysql = ShareVar.DBPass;
	
	String uid;
	String upassword;
	String uname;
	String uphone;
	String uemail;
	String uaddress;
	
	public Hsh_logindao() {
		// TODO Auto-generated constructor stub
	}

	public Hsh_logindao(String uid, String upassword) {
		super();
		this.uid = uid;
		this.upassword = upassword;
	}
	public boolean logincheck() {
		boolean check = false;
		String query = "select count(*) from customer where cid = '" + uid + "' and upassword = '" + upassword + "'";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(query);
			
			rs.next();
			int countNum = rs.getInt(1); 
			
			if (countNum == 1) {
				check = true;
			}
			
			conn_mysql.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
			return check;
	}
	
}

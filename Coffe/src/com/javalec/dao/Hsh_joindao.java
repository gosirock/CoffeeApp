package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.javalec.util.ShareVar;

public class Hsh_joindao {

	private final String url_mysql = ShareVar.DBName;
	private final String id_mysql = ShareVar.DBUser;
	private final String pw_mysql = ShareVar.DBPass;
	

	String uid;
	String upassword;
	String uname;
	String uphone;
	String uemail;
	String uaddress;
	String paypassword;
	
	public Hsh_joindao() {
		// TODO Auto-generated constructor stub
	}
	
	
	
//	회원가입
	public Hsh_joindao(String uid, String upassword, String uname, String uphone, String uemail, String uaddress, String paypassword) {
		super();
		this.uid = uid;
		this.upassword = upassword;
		this.uname = uname;
		this.uphone = uphone;
		this.uemail = uemail;
		this.uaddress = uaddress;
		this.paypassword = paypassword;
	}
	
	
	


	// 중복체크   ,, 결제비밀번호 생성자
	public Hsh_joindao(String uid) {
		super();
		this.uid = uid;
	}


	public boolean joinAction() {
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			String query = "insert into customer (cid, cname , cpassword, cphone, cemail, caddress, cinsertdate,cpayPassword)";
			String query1 = " values (?, ?, ?, ?, ?, ?, now(),?)";
			
			ps = conn_mysql.prepareStatement(query + query1);
			ps.setString(1, uid.trim());
			ps.setString(2, uname.trim());
			ps.setString(3, upassword.trim());
			ps.setString(4, uphone.trim());
			ps.setString(5, uemail.trim());
			ps.setString(6, uaddress.trim());
			ps.setString(7, paypassword.trim());
			
			ps.executeUpdate();
			conn_mysql.close();
			
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	
	
	
	
	
	
	
	public boolean dupCheck() {
		boolean check = false;
		String query = "select count(cid) from customer where cid = '" + uid + "'";
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
	
	
	public void payRegist() {
		
	
		
	}
	
}

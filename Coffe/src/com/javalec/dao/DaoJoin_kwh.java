package com.javalec.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.javalec.util.ShareVar;

public class DaoJoin_kwh {
	private final String url_mysql = ShareVar.DBName;
	private final String id_mysql = ShareVar.DBUser;
	private final String pw_mysql = ShareVar.DBPass;
	
	String cid;
	String cpassword;
	String cname;
	String cphone;
	String cemail;
	String caddress;
	String cpaypassword;
	Date cinsertdate;
	Date cdeletedate;
	
	
	public DaoJoin_kwh() {
		// TODO Auto-generated constructor stub
	}


	public DaoJoin_kwh(String cid) {
		super();
		this.cid = cid;
	}
	
	
	
	
	
	
	
	
	// function
	
	


	public DaoJoin_kwh(String cid, String cname, String cpassword, String cphone, String cemail, String caddress, Date cinsertdate
			) {
		super();
		this.cid = cid;
		this.cpassword = cpassword;
		this.cname = cname;
		this.cphone = cphone;
		this.cemail = cemail;
		this.caddress = caddress;
		this.cinsertdate = cinsertdate;
		
	}


	public boolean dupCheck() {
		boolean check = false;
		String query = "select count(*) from customer where cid = '" + cid + "'";
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
			return check;  // 같은 아이디가 없으면 check 에 0 을 dupcheck에 갖다줌 false
			
		}
			return check;  // 같은 아이디가 있으면 check에 1을 dupcheck에 갖다줌  true
		
	}
	

	//회원가입
		public boolean joinAction() {
			PreparedStatement ps = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
				Statement stmt_mysql = conn_mysql.createStatement();

				String query = "insert into customer (cid, cname , cpassword, cphone, cemail, caddress, cinsertdate,cpayPassword)";
				String query1 = " values (?, ?, ?, ?, ?, ?, ?,?)";
				
				ps = conn_mysql.prepareStatement(query + query1);
				ps.setString(1, cid.trim());
				ps.setString(2, cname.trim());
				ps.setString(3, cpassword.trim());
				ps.setString(4, cphone.trim());
				ps.setString(5, cemail.trim());
				ps.setString(6, caddress.trim());
				ps.setDate(7, cinsertdate);
				ps.setString(8, cpaypassword);
				
				ps.executeUpdate();
				conn_mysql.close();
				
				
			}catch(Exception e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}
	
	
}

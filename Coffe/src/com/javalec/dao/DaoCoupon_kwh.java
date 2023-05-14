package com.javalec.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.javalec.util.ShareVar;

public class DaoCoupon_kwh {
	// dB 연결하기 static 된 shareVar 로 연결하기
				private final String url_mysql = ShareVar.DBName;
				private final String id_mysql = ShareVar.DBUser;
				private final String pw_mysql = ShareVar.DBPass;

	
	
	int discount;
	String customer_cid;
	Date cpinsertdate;
	int cUse;

	
	
	public DaoCoupon_kwh() {
		// TODO Auto-generated constructor stub
	}



	public DaoCoupon_kwh(int discount, String customer_cid, Date cpinsertdate) {
		super();
		this.discount = discount;
		this.customer_cid = customer_cid;
		this.cpinsertdate = cpinsertdate;
	}
	
	
	
	
	// function
	
	public boolean insertAction() {   
		PreparedStatement ps = null ;
		try {  // java가 db에 접근했다.
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			String query = "insert into coupon (discount,customer_cid,cpinsertdate)";
			String query1 = " values (?,?,?)";
			
		
			
			
			ps = conn_mysql.prepareStatement(query + query1);
			ps.setInt(1, discount);
			ps.setString(2, customer_cid.trim());
			ps.setDate(3, cpinsertdate);
		
			
			//if()  쿠폰에 같은 고객이 있으면 안된다. select customer_cid from coupon where 
			
			
			ps.executeUpdate();
			conn_mysql.close();
			
	
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
	
	
	public boolean deleteAction() {  // 어제의 데이터를 지우는 쿼리문    메인이 오픈될때 DaoCoupon_kwh dao = new DaoCoupon_kwh dao.deleteAction();
		PreparedStatement ps = null ;
		try {  // java가 db에 접근했다.
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			String query = "DELETE FROM coupon WHERE DATE(cpinsertdate) = DATE_SUB(CURDATE(), INTERVAL 1 DAY)";
			
			
			ps = conn_mysql.prepareStatement(query );
		
			
			ps.executeUpdate();
			conn_mysql.close();
			
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
		
	
	
	
}

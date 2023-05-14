package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.javalec.util.ShareVar;

public class Lju_Dao_CouponCheck {


	private final String url_mysql = ShareVar.DBName;
	private final String id_mysql = ShareVar.DBUser;
	private final String pw_mysql = ShareVar.DBPass;
	public static String loginUserId;
	
	
	
	
	public Lju_Dao_CouponCheck() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	public int couponCheck() {
		int result = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			String query = "select count(*) from coupon where customer_cid = '"+ShareVar.loginUserId+"' and cpinsertdate = curdate() and cUse";
			
			ResultSet rs = stmt_mysql.executeQuery(query);
			while(rs.next()) {
				result = rs.getInt(1);	
			}
			
			if(result == 0) {
				String query1 = "select discount from coupon where customer_cid = '"+ShareVar.loginUserId+"' and cpinsertdate = curdate()";
				
				ResultSet rsCoupon = stmt_mysql.executeQuery(query1);
				while(rsCoupon.next()) {
					result = rsCoupon.getInt(1);
				}
				
				conn_mysql.close();	
				
			}else {
				
				return result;
			}
			}
		catch(Exception e) {
				e.printStackTrace();
				
			}
		return result;
		}
	
	
	
	
	
	
}

package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.javalec.util.ShareVar;

public class Lju_Dao_BasketAction {

	private final String url_mysql = ShareVar.DBName;
	private final String id_mysql = ShareVar.DBUser;
	private final String pw_mysql = ShareVar.DBPass;
	public static String loginUserId = "";
	
	String iid;
	String cid;
	String qty;
	
	public Lju_Dao_BasketAction() {
		// TODO Auto-generated constructor stub
	}

	public Lju_Dao_BasketAction(String iid, String qty) {
		super();
		this.iid = iid;
		this.qty = qty;
	}
	
	
	public boolean basketAction() {
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			
				String query = "insert into basket(item_iid, customer_cid, bqty)";
				String query1 = " values (?, ?, ?)";
				String query2 = " on duplicate key update bqty = bqty+?";
				
				ps = conn_mysql.prepareStatement(query + query1 + query2);
				ps.setString(1, iid.trim());
				ps.setString(2, "gosi");
				ps.setInt(3, Integer.parseInt(qty));
				ps.setInt(4, Integer.parseInt(qty));
				
				ps.executeUpdate();
				conn_mysql.close();	
				
				
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	
	
	
	
	
}

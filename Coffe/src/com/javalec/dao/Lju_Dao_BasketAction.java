package com.javalec.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.dto.Lju_dto;
import com.javalec.util.ShareVar;

public class Lju_Dao_BasketAction {

	private final String url_mysql = ShareVar.DBName;
	private final String id_mysql = ShareVar.DBUser;
	private final String pw_mysql = ShareVar.DBPass;
	public static String loginUserId;
	
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

	
	
	
	public Lju_Dao_BasketAction(String iid) {
		super();
		this.iid = iid;
		
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
	
	
	public int basketCount() {
		
		String query = "select count(*) from basket where customer_cid = '"+ ShareVar.loginUserId + "'";
		int count = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(query);
			rs.next();
			count = rs.getInt(1);
			conn_mysql.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	
	public ArrayList<Lju_dto> BasketLinst(){
		ArrayList<Lju_dto> dtoList = new ArrayList<Lju_dto>();
		
		String whereDefault = "select iname, iprice, iimagename, iimage, iid, bqty";
		String whereDefault1 = " from customer c, item i, basket b";
		String whereDefault2 = " where c.cid = b.customer_cid and i.iid = b.item_iid and c.cid = '"+ ShareVar.loginUserId +"'";
				
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(whereDefault+whereDefault1+whereDefault2);
			
			while(rs.next()) {
				String iname = rs.getString(1);
				int ipri = rs.getInt(2);
				String iimagename = rs.getString(3);
				
				File file = new File("./" + iimagename);
				FileOutputStream output = new FileOutputStream(file);
				InputStream input = rs.getBinaryStream(4);
				String iid = rs.getString(5);
				int bqty = rs.getInt(6);
				
				int iprice = ipri*bqty;
				byte[] buffer = new byte[1024];
				while(input.read(buffer) > 0) {
					output.write(buffer);
				
				
			}
				Lju_dto dto = new Lju_dto(iname, iprice, iimagename, iid, bqty);
				dtoList.add(dto);
			}
			conn_mysql.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return dtoList;
	}
	
}

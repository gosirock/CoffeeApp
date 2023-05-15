package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.javalec.dto.Kms_Dto_StoreInfo;
import com.javalec.util.ShareVar;

public class Kms_Dao_StoreInfo {
	
	private final String url_mysql = ShareVar.DBName;
	private final String id_mysql = ShareVar.DBUser;
	private final String pw_mysql = ShareVar.DBPass;

	String sname;
	String opentime;
	String closetime;
	String telno;
	String address;
	String cnum;
	int seq;
		
	
	public Kms_Dao_StoreInfo() {
		// TODO Auto-generated constructor stub
	}


	public Kms_Dao_StoreInfo(String sname,  String cnum,String opentime, String closetime, String telno, String address) {
		super();
		this.sname = sname;
		this.cnum = cnum;
		this.opentime = opentime;
		this.closetime = closetime;
		this.telno = telno;
		this.address = address;
	}
	
	public Kms_Dto_StoreInfo StoreInfo() {
		Kms_Dto_StoreInfo storeInfo = null;
		String query = "select sbusinessname, scompanyno, sopentime, sclosetime, stelno, slocation from cafe_app.store";
		 try {
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
		        Statement stmt_mysql = conn_mysql.createStatement();
		   
		        ResultSet rs = stmt_mysql.executeQuery(query);

		        if (rs.next()) {
		        	String wkSname = rs.getString(1);
		        	String wkCnum = rs.getString(2);
					String wkOpentime = rs.getString(3);
					String wkClosetime = rs.getString(4);
					String wkStelno = rs.getString(5);
					String wkSlocation = rs.getString(6);
					

		            storeInfo = new Kms_Dto_StoreInfo(wkSname, wkCnum, wkOpentime, wkClosetime, wkStelno, wkSlocation);
		        }
		        
		        conn_mysql.close();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    
		    return storeInfo;
		}
	
	public boolean updateAction() {
		PreparedStatement ps = null ;
		try {  // java가 db에 접근했다.
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			String query = "update cafe_app.store set sbusinessname = ?, scompanyno = ?, sopentime = ?, sclosetime = ?, stelno = ?, slocation = ?";
			String query1 = " where sSeq = 1";
			
			ps = conn_mysql.prepareStatement(query + query1);
			ps.setString(1, sname);   // 물음표 2번
			ps.setString(2, cnum.trim());
			ps.setString(3, opentime);
			ps.setString(4, closetime);
			ps.setString(5, telno);
			ps.setString(6, address);   // 물음표 6번
			
			
			ps.executeUpdate();
			conn_mysql.close();
			
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
}

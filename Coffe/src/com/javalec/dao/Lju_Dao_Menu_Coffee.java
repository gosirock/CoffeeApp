package com.javalec.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.dto.Lju_dto;
import com.javalec.util.ShareVar;

public class Lju_Dao_Menu_Coffee {
	
	private final String url_mysql = ShareVar.DBName;
	private final String id_mysql = ShareVar.DBUser;
	private final String pw_mysql = ShareVar.DBPass;
	
	String iid;
	String iname;
	int iprice;
	String iimagename;
	FileInputStream file;
	
	public Lju_Dao_Menu_Coffee() {
		// TODO Auto-generated constructor stub
	}


	
	
	
	// 메뉴불러오기
	
	public Lju_Dao_Menu_Coffee(String iid, String iname, int iprice, String iimagename) {
		super();
		this.iid = iid;
		this.iname = iname;
		this.iprice = iprice;
		this.iimagename = iimagename;
	}
	
	
	
	public Lju_Dao_Menu_Coffee(String iname) {
		super();
		this.iname = iname;
	}





	public ArrayList<Lju_dto> selectLinst(){
		ArrayList<Lju_dto> dtoList = new ArrayList<Lju_dto>();
		
		String whereDefault = "select idescription, iname, iprice, iimagename, iimage from item where iid like '%a%'";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(whereDefault);
			
			while(rs.next()) {
				String idescription = rs.getString(1);
				String iname = rs.getString(2);
				int iprice = rs.getInt(3);
				String iimagename = rs.getString(4);
				
				File file = new File("./" + iimagename);
				FileOutputStream output = new FileOutputStream(file);
				InputStream input = rs.getBinaryStream(5);
				
				byte[] buffer = new byte[1024];
				while(input.read(buffer) > 0) {
					output.write(buffer);
				
				
			}
				Lju_dto dto = new Lju_dto(idescription, iname, iprice, iimagename);
				dtoList.add(dto);
			}
			conn_mysql.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return dtoList;
	}

	
	public ArrayList<Lju_dto> SearchAction(){
		
		ArrayList<Lju_dto> dtoList = new ArrayList<Lju_dto>();
		String whereDefault = "select idescription, iname, iprice, iimagename, iimage, iid from item";
		String whereDefault1 = " where iid like '%a%' and iname like '%" + iname + "%'";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(whereDefault + whereDefault1);
			
			while(rs.next()) {
				String idescription = rs.getString(1);
				String iname = rs.getString(2);
				int iprice = rs.getInt(3);
				String iimagename = rs.getString(4);
				
				File file = new File("./" + iimagename);
				FileOutputStream output = new FileOutputStream(file);
				InputStream input = rs.getBinaryStream(5);
				String iid = rs.getString(6);
				
				byte[] buffer = new byte[1024];
				while(input.read(buffer) > 0) {
					output.write(buffer);
				
			}
				Lju_dto dto = new Lju_dto(idescription, iname, iprice, iimagename, iid);
				dtoList.add(dto);
			}
			conn_mysql.close();
						
		}catch(Exception e) {
			e.printStackTrace();
		}

		return dtoList;


		
	}
	
	
	//////////////
	
	
	
	public ArrayList<Lju_dto> Linst(){
		ArrayList<Lju_dto> dtoList = new ArrayList<Lju_dto>();
		
		String whereDefault = "select idescription, iname, iprice, iimagename, iimage, iid from item where iid like '%a%'";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(whereDefault);
			
			while(rs.next()) {
				String idescription = rs.getString(1);
				String iname = rs.getString(2);
				int iprice = rs.getInt(3);
				String iimagename = rs.getString(4);
				
				File file = new File("./" + iimagename);
				FileOutputStream output = new FileOutputStream(file);
				InputStream input = rs.getBinaryStream(5);
				String iid = rs.getString(6);
				byte[] buffer = new byte[1024];
				while(input.read(buffer) > 0) {
					output.write(buffer);
				
				
			}
				Lju_dto dto = new Lju_dto(idescription, iname, iprice, iimagename, iid);
				dtoList.add(dto);
			}
			conn_mysql.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return dtoList;
	}
}

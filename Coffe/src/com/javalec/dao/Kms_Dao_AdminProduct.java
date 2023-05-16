package com.javalec.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.dto.Kms_Dto_AdminProduct;
import com.javalec.dto.Kms_Dto_AdminProduct;
import com.javalec.util.ShareVar;

public class Kms_Dao_AdminProduct {
	
	private final String url_mysql = ShareVar.DBName;
	private final String id_mysql = ShareVar.DBUser;
	private final String pw_mysql = ShareVar.DBPass;
	
	String iid;
	String iname;
	int iprice;
	int istock;
	String iimagename;
	FileInputStream iimage;
	String idescription;

	String conname;
	String condata;

	public Kms_Dao_AdminProduct() {
		// TODO Auto-generated constructor stub
		
	}
	public Kms_Dao_AdminProduct(String conname, String condata) {
		super();
		this.conname = conname;
		this.condata = condata;
	}
	public Kms_Dao_AdminProduct(String iid, String iname, int iprice, int istock, String iimagename,
			FileInputStream iimage, String idescription) {
		super();
		this.iid = iid;
		this.iname = iname;
		this.iprice = iprice;
		this.istock = istock;
		this.iimagename = iimagename;
		this.iimage = iimage;
		this.idescription = idescription;
	}
	public Kms_Dao_AdminProduct(String iid, String iname, int iprice, int istock, String iimagename,
			String idescription) {
		super();
		this.iid = iid;
		this.iname = iname;
		this.iprice = iprice;
		this.istock = istock;
		this.iimagename = iimagename;
		this.idescription = idescription;
	}
	
	
	
	public Kms_Dao_AdminProduct(String iid, String iname, int iprice, int istock, String idescription) {
		super();
		this.iid = iid;
		this.iname = iname;
		this.iprice = iprice;
		this.istock = istock;
		this.idescription = idescription;
	}
	
	

	public Kms_Dao_AdminProduct(String iid) {
		super();
		this.iid = iid;
	}
	public Kms_Dto_AdminProduct tableclick() {
		Kms_Dto_AdminProduct dto = null;
		
		String whereDefault = "select iid, iname, iprice, istock, iimagename, idescription,iimage from cafe_app.item";    // select from 은 이렇게하기
		String whereDefault1 = " where iid = '" + iid + "'";
		try {  // java가 db에 접근했다.
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereDefault + whereDefault1);
			
			while(rs.next()) { // rs.next는 다음이있으면 1 . 없으면 0;
				String wkIid = rs.getString(1);
				String wkIname = rs.getString(2);
				int wkIprice = rs.getInt(3);
				int wkIstock = rs.getInt(4);
				String wkIimagename = rs.getString(5);
				String wkIdescription = rs.getString(6);
				
				// File 불러오기
				File file = new File("./" + wkIimagename);
				FileOutputStream output = new FileOutputStream(file);   // fileoutputstream은 file만드는 클래스
				InputStream input = rs.getBinaryStream(7);  // db에서 image를 가져오는 것
				byte[] buffer = new byte[1024];  // 1024는 한번에 불러오는 파일의 크기 버퍼가 바이트배열로 만들어지는데 그림의 일부분(정해준 크기)만큼씩 블록으로 생성하여 배열로 들어옴
				while(input.read(buffer)>0) {
					output.write(buffer);
					
				}
				
				
				
				// 위에 6개를 한번에 넣기  -> Dto 에서 1개의 데이터 생성자를 만들어놓음
				dto = new Kms_Dto_AdminProduct(wkIid, wkIname, wkIprice, wkIstock, wkIimagename, wkIdescription);
				
				
			}
			
			conn_mysql.close();
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return dto;
	}
	
	public ArrayList<Kms_Dto_AdminProduct> selectList(){
		ArrayList<Kms_Dto_AdminProduct> dtoList = new ArrayList<Kms_Dto_AdminProduct>(); 
			String whereDefault = "select iid, iname, istock, iprice, idescription from cafe_app.item";    // select from 은 이렇게하기
			try {  // java가 db에 접근했다.
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
				Statement stmt_mysql = conn_mysql.createStatement();

				ResultSet rs = stmt_mysql.executeQuery(whereDefault);
				
				while(rs.next()) { // rs.next는 다음이있으면 1 . 없으면 0;
					String wkID = rs.getString(1);
					String wkName = rs.getString(2);
					int wkStock = rs.getInt(3);
					int wkPrice = rs.getInt(4);
					String wkDescription = rs.getString(5);
					
					// 위에 5개를 한번에 넣기  -> Dto 에서 4개의 데이터 생성자를 만들어놓음
					Kms_Dto_AdminProduct dto = new Kms_Dto_AdminProduct(wkID, wkName, wkPrice, wkStock, wkDescription);
					dtoList.add(dto);
					
				}
				
				conn_mysql.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return dtoList;
		
		
	}
	
	public boolean insertAction() {   
		PreparedStatement ps = null ;
		try {  // java가 db에 접근했다.
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			String query = "insert into cafe_app.item (iid,iname,iprice,istock,iimagename,iimage,idescription)";
			String query1 = " values (?,?,?,?,?,?,?)";
			
			ps = conn_mysql.prepareStatement(query + query1);
			ps.setString(1, iid.trim());
			ps.setString(2, iname.trim());
			ps.setInt(3, iprice);
			ps.setInt(4, istock);
			// File 추가
			ps.setString(5, iimagename);
			ps.setBinaryStream(6, iimage);
			ps.setString(7, idescription);
			
			
			ps.executeUpdate();
			conn_mysql.close();
			
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
	
	public boolean updateAction() {
		PreparedStatement ps = null ;
		try {  // java가 db에 접근했다.
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			String query = "update product set iname = ?, istock = ?, iprice = ?, iimagename = ?, idescription = ?";
			String query1 = " where iid = ?";
			
			ps = conn_mysql.prepareStatement(query + query1);
			ps.setString(2, iname.trim());
			ps.setInt(3, istock);
			ps.setInt(4, iprice);
			ps.setString(5, iimagename);
			ps.setString(1, idescription);  
			ps.setString(6, iid);   
			
			
			ps.executeUpdate();
			conn_mysql.close();
			
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public boolean deleteAction() {
		PreparedStatement ps = null ;
		try {  // java가 db에 접근했다.
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			String query = "delete from cafe_app.item where iid = ?";
			
			ps = conn_mysql.prepareStatement(query);
			ps.setString(1,iid);
			
			
			
			ps.executeUpdate();
			conn_mysql.close();
			
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public ArrayList<Kms_Dto_AdminProduct> conditionList(){
		ArrayList<Kms_Dto_AdminProduct> dtoList = new ArrayList<Kms_Dto_AdminProduct>();
		
		String whereDefault = "select iid, iname, iprice, istock from cafe_app.item";
		String whereDefault1 = " where " + conname + " like '%" + condata + "%'";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(whereDefault + whereDefault1);
			
			while(rs.next()) {
				String iid = rs.getString(1);
				String iname = rs.getString(2);
				int iprice = rs.getInt(3);
				int istock = rs.getInt(4);
				
				Kms_Dto_AdminProduct dto = new Kms_Dto_AdminProduct(iid, iname, iprice, istock);
				dtoList.add(dto);
			}

			conn_mysql.close();
						
		}catch(Exception e) {
			e.printStackTrace();
		}

		return dtoList;

	
	}
	
	}

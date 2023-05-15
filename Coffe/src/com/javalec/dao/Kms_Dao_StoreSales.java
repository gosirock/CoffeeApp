package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

import com.javalec.dto.Kms_Dto_AdminProduct;
import com.javalec.dto.Kms_Dto_StoreSales;
import com.javalec.util.ShareVar;

public class Kms_Dao_StoreSales {
	
	private final String url_mysql = ShareVar.DBName;
	private final String id_mysql = ShareVar.DBUser;
	private final String pw_mysql = ShareVar.DBPass;
	
	int seqno;
	String date;
	int price;
	int sales;

	public Kms_Dao_StoreSales() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Kms_Dao_StoreSales(int seqno, String date, int price) {
		super();
		this.seqno = seqno;
		this.date = date;
		this.price = price;
	}


	public ArrayList<Kms_Dto_StoreSales> selectList(){
		ArrayList<Kms_Dto_StoreSales> dtoList = new ArrayList<Kms_Dto_StoreSales>(); 
			String whereDefault = "select pSeq, pdate, psaleprice from cafe_app.purchase";    // select from 은 이렇게하기
			try {  // java가 db에 접근했다.
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
				Statement stmt_mysql = conn_mysql.createStatement();

				ResultSet rs = stmt_mysql.executeQuery(whereDefault);
				
				while(rs.next()) { // rs.next는 다음이있으면 1 . 없으면 0;
					int wkSeqno = rs.getInt(1);
					String wkDate = rs.getString(2);
					int wkPrice = rs.getInt(3);
					
					
					
					// 위에 5개를 한번에 넣기  -> Dto 에서 4개의 데이터 생성자를 만들어놓음
					Kms_Dto_StoreSales dto = new Kms_Dto_StoreSales(wkSeqno, wkDate, wkPrice);
					dtoList.add(dto);
					
				}
				
				conn_mysql.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return dtoList;
		
		
	}
	
	public ArrayList<Kms_Dto_StoreSales> dayselectList(){
		ArrayList<Kms_Dto_StoreSales> dtoList = new ArrayList<Kms_Dto_StoreSales>(); 
			String whereDefault = "select pSeq, pdate, psaleprice from cafe_app.purchase where pdate = curdate()";    // select from 은 이렇게하기
			try {  // java가 db에 접근했다.
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
				Statement stmt_mysql = conn_mysql.createStatement();

				ResultSet rs = stmt_mysql.executeQuery(whereDefault);
				
				while(rs.next()) { // rs.next는 다음이있으면 1 . 없으면 0;
					int wkSeqno = rs.getInt(1);
					String wkDate = rs.getString(2);
					int wkPrice = rs.getInt(3);
					
					
					
					// 위에 5개를 한번에 넣기  -> Dto 에서 4개의 데이터 생성자를 만들어놓음
					Kms_Dto_StoreSales dto = new Kms_Dto_StoreSales(wkSeqno, wkDate, wkPrice);
					dtoList.add(dto);
					
				}
				
				conn_mysql.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return dtoList;
		
		
	}
	
	public ArrayList<Kms_Dto_StoreSales> yDayselectList(){
		ArrayList<Kms_Dto_StoreSales> dtoList = new ArrayList<Kms_Dto_StoreSales>(); 
			String whereDefault = "SELECT pSeq, pdate, psaleprice FROM cafe_app.purchase where pdate = DATE_SUB(CURDATE(), INTERVAL 1 DAY)";    // select from 은 이렇게하기
			try {  // java가 db에 접근했다.
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
				Statement stmt_mysql = conn_mysql.createStatement();

				ResultSet rs = stmt_mysql.executeQuery(whereDefault);
				
				while(rs.next()) { // rs.next는 다음이있으면 1 . 없으면 0;
					int wkSeqno = rs.getInt(1);
					String wkDate = rs.getString(2);
					int wkPrice = rs.getInt(3);
					
					
					
					// 위에 5개를 한번에 넣기  -> Dto 에서 4개의 데이터 생성자를 만들어놓음
					Kms_Dto_StoreSales dto = new Kms_Dto_StoreSales(wkSeqno, wkDate, wkPrice);
					dtoList.add(dto);
					
				}
				
				conn_mysql.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return dtoList;
		
		
	}
	
	
}

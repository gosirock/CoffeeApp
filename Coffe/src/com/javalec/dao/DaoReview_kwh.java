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

import java.sql.Date;
import java.time.LocalDateTime;  // java.time 패키지의 LocalDateTime 클래스 임포트
import java.util.ArrayList;

import com.javalec.dto.DtoReview_kwh;
import com.javalec.util.ShareVar;

public class DaoReview_kwh {
	
	// dB 연결하기 static 된 shareVar 로 연결하기
			private final String url_mysql = ShareVar.DBName;
			private final String id_mysql = ShareVar.DBUser;
			private final String pw_mysql = ShareVar.DBPass;
			
			
			String irid;
			String crid;
			String title;
			String comment;
			String rimagename="";
			LocalDateTime rinsertdate = LocalDateTime.now();  // 현재 시간을 LocalDateTime 객체로 가져오기
			Date rinsertdates;
			
			String iname;
			int iprice;
			
			

			
			// File
			FileInputStream rimage;
			
			public DaoReview_kwh() {
				// TODO Auto-generated constructor stub
			}
			
			
			
			
			public DaoReview_kwh(String irid, String crid, String title, String comment, String rimagename, LocalDateTime rinsertdate,
					FileInputStream rimage) {
				super();
				
				this.irid = irid;
				this.crid=crid;
				this.title = title;
				this.comment = comment;
				this.rimagename = rimagename;
				this.rinsertdate = rinsertdate;
				this.rimage = rimage;
			}
			
			
			
			public DaoReview_kwh(String irid, String crid, String title, String comment, String rimagename, Date rinsertdates,
					FileInputStream rimage) {
				super();
				this.irid = irid;
				this.crid=crid;
				this.title = title;
				this.comment = comment;
				this.rimagename = rimagename;
				this.rinsertdate = rinsertdate;
				this.rimage = rimage;
			}
			
			
			
			
			
			
			
			
			
			public DaoReview_kwh(String crid, String iname, int iprice, String title, String comment, String rimagename,
					  FileInputStream rimage,LocalDateTime rinsertdate) {
				super();
				this.crid = crid;
				this.title = title;
				this.comment = comment;
				this.rimagename = rimagename;
				this.rinsertdate = rinsertdate;
				this.iname = iname;
				this.iprice = iprice;
				this.rimage = rimage;
			}




			// function
			
			
			// 리뷰등록
			
			public boolean postAction() {   
				PreparedStatement ps = null ;
				try {  // java가 db에 접근했다.
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
					Statement stmt_mysql = conn_mysql.createStatement();

					String query = "insert into review (irid,crid,title,comment,rinsertdate,rimagename,rimage)";
					String query1 = " values (?,?,?,?,?,?,?)";
						
					
					ps = conn_mysql.prepareStatement(query + query1);
					ps.setString(1, irid.trim());
					ps.setString(2, crid.trim());
					ps.setString(3, title.trim());
					ps.setString(4, comment.trim());
					ps.setDate(5, rinsertdates);
					ps.setString(6, rimagename);
					
					// File 추가
					ps.setBinaryStream(7, rimage);
			
					
					
					ps.executeUpdate();
					conn_mysql.close();
					
			
					
				}catch(Exception e) {
					e.printStackTrace();
					return false;
				}
				return true;
				
			}
			
			
			public ArrayList<DtoReview_kwh> selectList(){
				ArrayList<DtoReview_kwh> dtoList = new ArrayList<DtoReview_kwh>(); 
					String whereDefault = "select r.crid, i.iname , i.iprice, r.title, r.reply,r.rimagename,r.rimage,r.rinsertdate from item i , review as r, customer c ";    // select from 은 이렇게하기
					String whereDefault1 = " where i.iid = r.irid and c.cid = r.crid";    // select from 은 이렇게하기
					try {  // java가 db에 접근했다.
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
						Statement stmt_mysql = conn_mysql.createStatement();

						ResultSet rs = stmt_mysql.executeQuery(whereDefault);
						
						while(rs.next()) { // rs.next는 다음이있으면 1 . 없으면 0;
							String wkID = rs.getString(1);
							String wkItem = rs.getString(2);
							int wkPrice = rs.getInt(3);
							String wkTitle = rs.getString(4);
							String wkReply = rs.getString(5);
							String wkImagename = rs.getString(6);
							
							File file = new File("./" + rimagename);
							FileOutputStream output = new FileOutputStream(file);
							InputStream input = rs.getBinaryStream(7);
							
							Date wkDate = rs.getDate(8);
							
							// 위에 5개를 한번에 넣기  -> Dto 에서 4개의 데이터 생성자를 만들어놓음
							DtoReview_kwh dto = new DtoReview_kwh(wkID, wkItem, wkPrice, wkTitle, wkReply, wkImagename, input, wkDate);
							dtoList.add(dto);
							
						}
						
						conn_mysql.close();
						
					}catch(Exception e) {
						e.printStackTrace();
					}
					
					return dtoList;
				
				
			}
}

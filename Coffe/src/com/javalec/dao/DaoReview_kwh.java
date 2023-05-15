package com.javalec.dao;

import java.awt.Image;
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
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.javalec.dto.DtoReview_kwh;
import com.javalec.util.ShareVar;

public class DaoReview_kwh {
	
	// dB 연결하기 static 된 shareVar 로 연결하기
			private final String url_mysql = ShareVar.DBName;
			private final String id_mysql = ShareVar.DBUser;
			private final String pw_mysql = ShareVar.DBPass;
			
			
			String item_iid;
			String customer_cid;
			String title;
			String comment;
			String rimagename= "image.png";
			Date rinsertdate;
			
			String iname;
			int iprice;
			
			Image image;

			
			// File
			FileInputStream rimage;
			
			public DaoReview_kwh() {
				// TODO Auto-generated constructor stub
			}
			
			
			
		
			
			//리뷰등록생성자
			
			public DaoReview_kwh(String item_iid, String customer_cid, String title, String comment, String rimagename, Date rinsertdate,
					FileInputStream rimage) {
				super();
				this.item_iid = item_iid;
				this.customer_cid=customer_cid;
				this.title = title;
				this.comment = comment;
				this.rimagename = rimagename;
				this.rinsertdate = rinsertdate;
				this.rimage = rimage;
			}
			
			
			// 기본사진을 등록하는 생성자
			public DaoReview_kwh(String item_iid, String customer_cid, String title, String comment, String rimagename, Date rinsertdate,
					FileInputStream rimage, Image image) {
				super();
				this.item_iid = item_iid;
				this.customer_cid=customer_cid;
				this.title = title;
				this.comment = comment;
				this.rimagename = rimagename;
				this.rinsertdate = rinsertdate;
				this.rimage = rimage;
				this.image = image;
			}
			
			
			
			
			




			// function
			
			
			// 리뷰등록
			
			public boolean postAction() {   
				PreparedStatement ps = null ;
				try {  // java가 db에 접근했다.
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
					Statement stmt_mysql = conn_mysql.createStatement();

					String query = "insert into review (item_iid,customer_cid,title,reply,rinsertdate,rimagename,rimage)";
					String query1 = " values (?,?,?,?,?,?,?)";
				
					
					
					ps = conn_mysql.prepareStatement(query + query1);
					ps.setString(1, item_iid.trim());
					ps.setString(2, customer_cid.trim());
					ps.setString(3, title);
					ps.setString(4, comment);
					ps.setDate(5, rinsertdate);
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
			
			//데이터들 불러와서 한줄에넣기
			
			public ArrayList<DtoReview_kwh> selectList(){

				ArrayList<DtoReview_kwh> dtoList = new ArrayList<DtoReview_kwh>(); 
					
					String whereDefault = "select r.customer_cid, i.iname , i.iprice, r.title, r.reply,r.rimagename,r.rimage,r.rinsertdate from item i , review as r, customer c ";    // select from 은 이렇게하기
					String whereDefault1 = " where i.iid = r.item_iid and c.cid = r.customer_cid";    // select from 은 이렇게하기
					String whereDefault2 = " order by rSeq desc";    // 최신순으로 정렬  내림차순 = rSeq가 큰 순으로 정렬 rSeq는 오토
					
					try {  // java가 db에 접근했다.
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
						Statement stmt_mysql = conn_mysql.createStatement();

						
						
						ResultSet rs = stmt_mysql.executeQuery(whereDefault+whereDefault1+whereDefault2);
						
						
						 
						 
						while(rs.next()) { // rs.next는 다음이있으면 1 . 없으면 0;
							String wkID = rs.getString(1);
							String wkItem = rs.getString(2);
							int wkPrice = rs.getInt(3);
							String wkTitle = rs.getString(4);
							String wkReply = rs.getString(5);
							String wkImagename = rs.getString(6);
							
							File file = new File("./" + wkImagename);
							FileOutputStream output = new FileOutputStream(file);     //outputstream 은 select
							
							InputStream input = rs.getBinaryStream(7);
							Date wkDate = rs.getDate(8);
							
							byte[] buffer = new byte[1024];
							while(input.read(buffer) >= 0) {
								output.write(buffer);
							
							
						}
							
							// 위에 8개를 한번에 넣기  -> Dto 에서 8개의 데이터 생성자를 만들어놓음
							DtoReview_kwh dto = new DtoReview_kwh(wkID, wkItem, wkPrice, wkTitle, wkReply, wkImagename, wkDate);
							dtoList.add(dto);
							}	
						
						conn_mysql.close();
						rs.close();
					    stmt_mysql.close();    // 닫아줘야 계속실행안함
					    
					    
						}catch(Exception e) {
						e.printStackTrace();
					}
					
					
					return dtoList;
				
				
			
			}
			
			
			
			
			
			
			
			public ArrayList<DtoReview_kwh> checkList() {
			    ArrayList<DtoReview_kwh> dtoList = new ArrayList<DtoReview_kwh>();    // 쿼리문 = 데이터베이스에서 데이터를 가져오는데 댓글에서 커피명이 많은 순서부터 데이터를 정렬해서 가져오기
			    String whereDefault = "SELECT r.customer_cid, i.iname, i.iprice, r.title, r.reply, r.rimagename, r.rimage, r.rinsertdate FROM item i JOIN review r ON i.iid = r.item_iid JOIN customer c ON c.cid = r.customer_cid";    // select from 은 이렇게하기
			    String whereDefault1 = " JOIN (\n"
			    		+ "    SELECT i.iname, COUNT(*) AS count\n"
			    		+ "    FROM item i\n"
			    		+ "    JOIN review r ON i.iid = r.item_iid\n"
			    		+ "    GROUP BY i.iname\n"
			    		+ "    ORDER BY COUNT(*) DESC\n"
			    		+ ") subquery ON i.iname = subquery.iname\n"
			    		+ "ORDER BY subquery.count DESC, i.iname";    // select from 은 이렇게하기
			    try {  // java가 db에 접근했다.
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
					Statement stmt_mysql = conn_mysql.createStatement();

					
					
					ResultSet rs = stmt_mysql.executeQuery(whereDefault+whereDefault1);
					
					
					 
					 
					while(rs.next()) { // rs.next는 다음이있으면 1 . 없으면 0;
						String wkID = rs.getString(1);
						String wkItem = rs.getString(2);
						int wkPrice = rs.getInt(3);
						String wkTitle = rs.getString(4);
						String wkReply = rs.getString(5);
						String wkImagename = rs.getString(6);
						
						File file = new File("./" + wkImagename);
						FileOutputStream output = new FileOutputStream(file);     //outputstream 은 select
						
						InputStream input = rs.getBinaryStream(7);
						Date wkDate = rs.getDate(8);
						
						byte[] buffer = new byte[1024];
						while(input.read(buffer) >= 0) {
							output.write(buffer);
						
						
					}
						
						// 위에 8개를 한번에 넣기  -> Dto 에서 8개의 데이터 생성자를 만들어놓음
						DtoReview_kwh dto = new DtoReview_kwh(wkID, wkItem, wkPrice, wkTitle, wkReply, wkImagename, wkDate);
						dtoList.add(dto);
						}	
					
					conn_mysql.close();
					rs.close();
				    stmt_mysql.close();    // 닫아줘야 계속실행안함
				    
				    
					}catch(Exception e) {
					e.printStackTrace();
				}
				
				
				return dtoList;
			    
			}

			
			
			
			
}


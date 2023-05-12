package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.dto.DtoBasket_kwh;
import com.javalec.util.ShareVar;

public class DaoBasket_kwh {
	
	// dB 연결하기 static 된 shareVar 로 연결하기
				private final String url_mysql = ShareVar.DBName;
				private final String id_mysql = ShareVar.DBUser;
				private final String pw_mysql = ShareVar.DBPass;

				
				public DaoBasket_kwh() {
					// TODO Auto-generated constructor stub
				}
				
				
				public ArrayList<DtoBasket_kwh> selectLinst(){
					ArrayList<DtoBasket_kwh> dtoList = new ArrayList<DtoBasket_kwh>();
					
					String whereDefault = "select i.iid, i.iname, i.iprice, b.qty";
					String whereDefault1 = " from product p, user u, basket b";
					String whereDefault2 = " where u.userid = b.user_userid and p.pid = b.product_pid and u.userid = " + "'"+ ShareVar.loginUserId+"'";
					
					
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
						Statement stmt_mysql = conn_mysql.createStatement();
						
						ResultSet rs = stmt_mysql.executeQuery(whereDefault+whereDefault1+whereDefault2);
						
						while(rs.next()) {
							String iid = rs.getString(1);
							String iname = rs.getString(2);
							int pprice = rs.getInt(3);
							int bqty = rs.getInt(5);
							
							DtoBasket_kwh dtoBasket = new DtoBasket_kwh(iid, iname, pprice, bqty);
							dtoList.add(dtoBasket);
						}
						conn_mysql.close();
						
					}catch(Exception e) {
						e.printStackTrace();
					}
					
					return dtoList;
				}
}

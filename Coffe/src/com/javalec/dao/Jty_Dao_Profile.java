package com.javalec.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

import com.javalec.dto.Jty_Dto_Profile;
import com.javalec.util.ShareVar;



public class Jty_Dao_Profile {
	
	private final String url_mysql = ShareVar.DBName;
	private final String id_mysql = ShareVar.DBUser;
	private final String pw_mysql = ShareVar.DBPass;
	
	String cname;
	String cid;
	String cpassword;
	String cphone;
	String cemail;
	String caddress;
	String paymentPassword;
	String cinsertdate;
	String cdeletedate;
	
	
	
	public Jty_Dao_Profile() {
		// TODO Auto-generated constructor stub
	}
	
	
	
public Jty_Dao_Profile(String cid) {
		super();
		this.cid = cid;
	}

public Jty_Dao_Profile(String cpassword, String cname, String cphone, String cemail, String caddress) {
	super();
	this.cpassword = cpassword;
	this.cname = cname;
	this.cphone = cphone;
	this.cemail = cemail;
	this.caddress = caddress;
	//this.paymentPassword = paymentPassword;
}
	


// SELECT SUBSTRING_INDEX(cemail, '@', 1) from customer; 
	public Jty_Dto_Profile openProfile() {
	    Jty_Dto_Profile jtyDtoProfile = null;
	    String query = "SELECT cid, cpassword, cname, cphone, cemail, caddress, cpayPassword, cinsertdate ";
	    String query1 = "FROM customer WHERE cid = ?";
	    
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
	        PreparedStatement pstmt = conn_mysql.prepareStatement(query + query1);
	        
	        pstmt.setString(1, ShareVar.loginUserId);
	        ResultSet rs = pstmt.executeQuery();

	        if (rs.next()) {
	            String cid = rs.getString("cid");
	            String cpassword = rs.getString("cpassword");
	            String cname = rs.getString("cname");
	            String cphone = rs.getString("cphone");
	            String cemail = rs.getString("cemail");
	            String caddress = rs.getString("caddress");
	            String cpayPassword = rs.getString("cpayPassword");
	            String cinsertdate = rs.getString("cinsertdate");

	            jtyDtoProfile = new Jty_Dto_Profile(cid, cpassword, cname, cphone, cemail, caddress, cpayPassword, cinsertdate);
	        }
	        
	        conn_mysql.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    return jtyDtoProfile;
	}

	
	
	public boolean userDelete() {
	    PreparedStatement pstmt = null;
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);

	        String query = "UPDATE customer SET cdeletedate = NOW() WHERE cid = ?";
	        pstmt = conn_mysql.prepareStatement(query);

	        pstmt.setString(1, ShareVar.loginUserId);

	        pstmt.executeUpdate();
	        conn_mysql.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }

	    return true;
	}

//	public void deleteUser() {
//	    try {
//	        Class.forName("com.mysql.cj.jdbc.Driver");
//	        Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
//
//	        String query = "UPDATE customer SET cdeletedate = NOW() WHERE cid = ?";
//	        PreparedStatement pstmt = conn_mysql.prepareStatement(query);
//
//	        pstmt.setString(1, cid);
//
//	        int rowsAffected = pstmt.executeUpdate();
//	        conn_mysql.close();
//
//	        if (rowsAffected > 0) {
//	            JOptionPane.showMessageDialog(this, "회원탈퇴\n"+tfName.getText()+ "님의 회원탈퇴가 완료되었습니다.", "주소록 정보", JOptionPane.INFORMATION_MESSAGE);
//	        } else {
//	            System.out.println("dddd");
//	        }
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    }
//	}

	public boolean dobCheck() {
		boolean check = false;
		String query = "select count(*) from customer where cid = '" + cid + "'";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(query);
			
			rs.next();
			int countNum = rs.getInt(1); 
			
			if (countNum == 1) {
				check = true;
			}
			
			conn_mysql.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
			return check;
		
	}
	
	public boolean allUpdateAction() {
	    PreparedStatement ps = null;
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);

	        // Update customer record
	        String updateCustomerQuery = "UPDATE customer SET cpassword = ?, cname = ?, cphone = ?, cemail = ?, caddress = ? WHERE cid = '" + "gosi" + "'";
	        ps = conn_mysql.prepareStatement(updateCustomerQuery);
	       
	        ps.setString(1, cpassword.trim());
	        ps.setString(2, cname.trim());
	        ps.setString(3, cphone.trim());
	        ps.setString(4, cemail.trim());
	        ps.setString(5, caddress.trim());
	        
	        //ps.setString(7, ShareVar.loginUserId);
	        ps.executeUpdate();

	        conn_mysql.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	    return true;
	}





	
}

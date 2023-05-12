package com.javalec.util;

public class ShareVar {
	
	// dB변경되면 여기서 변경시켜주면 됨
	
	public static final String DBName = "jdbc:mysql://127.0.0.1/cafe?serverTimezone=UTC&characterEncoding=utf8&useSSL=FALSE";
	public static final String DBUser = "root";
	public static final String DBPass = "qwer1234";
	public static int filename = 0;  // dB에서의 blob을 file로 바꾸기 위해 해주는 작업
	
	
	public static String loginUserId = "";
	public static String ItemId = "";
	
	
	public static String testid = "wook";
	public static String testitem = "i-01";
	
	
	
}

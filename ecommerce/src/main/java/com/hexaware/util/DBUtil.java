package com.hexaware.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	static Connection con;
	public static Connection getDBConn() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecom", "root", "Sudeshna@11");		
			}
		catch(SQLException e) {
			e.printStackTrace();
			}
		return con;
		
	}
	public static void main(String[] args) {
		System.out.println(getDBConn());
	}

}

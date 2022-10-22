package com.unifacisa.ouvidoria.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDAO {
	public Connection connectDB() {
		Connection conn = null;
		
		try {
			String url = "jdbc:mysql://localhost:3306/db_ouvidoria?user=root&password=root";
			conn = DriverManager.getConnection(url);
		} catch (SQLException err) {
			System.out.println("ConnectionDAO" + err.getMessage());
		}
		return conn;
	}
}

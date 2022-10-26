package com.unifacisa.ouvidoria.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.unifacisa.ouvidoria.utils.Formatter;

public class ConnectionDAO {
	public Connection connectDB() {
		Formatter formatter = new Formatter();
		Connection conn = null;
		
		try {
			String url = "jdbc:mysql://localhost:3306/db_ouvidoria?user=root&password=root";
			conn = DriverManager.getConnection(url);
		} catch (SQLException err) {
			formatter.errorEmitter("Nao foi possivel se conectar ao banco de dados!");
			System.out.println("ConnectionDAO: " + err.getMessage());
		}
		return conn;
	}
}

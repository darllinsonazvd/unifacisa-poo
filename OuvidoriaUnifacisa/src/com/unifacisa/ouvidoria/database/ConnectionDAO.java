package com.unifacisa.ouvidoria.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.unifacisa.ouvidoria.utils.Formatter;

/**
 * @apiNote Classe de conexão ao banco de dados MySQL
 *
 * @author Darllinson Azevedo
 */
public class ConnectionDAO {
	/**
	 * @apiNote Conectar ao banco de dados
	 *
	 * @author Darllinson Azevedo
	 *
	 * @return Conexão do banco de dados MySQL
	 */
	public static Connection connectDB() {
		Formatter formatter = new Formatter();
		Connection conn = null;

		final String url = "jdbc:mysql://localhost:3306/db_ouvidoria?user=root&password=password&useSSL=false";

		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException err) {
			formatter.errorEmitter("Nao foi possivel se conectar ao banco de dados!");
			System.out.println("ConnectionDAO: " + err.getMessage());
		}
		return conn;
	}
}

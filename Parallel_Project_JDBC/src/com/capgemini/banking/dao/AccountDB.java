package com.capgemini.banking.dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountDB {

	private static final String DB_SERVER = "jdbc:oracle:thin:@Localhost:1521:xe";
	private static final String USERNAME = "INVENTORY1";
	private static final String PASSWORD = "INVENTORY1";

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(DB_SERVER, USERNAME, PASSWORD);
		return conn;
	}

	static {
		Connection conn;
		Statement stmt = null;
		ResultSet result = null;
		DatabaseMetaData dbm = null;
		try {
			conn = getConnection();
			dbm = conn.getMetaData();
			result = dbm.getTables(null, null, "bank_wallet_account", null);
			conn.close();
		} catch (ClassNotFoundException e) {
			System.out.println("Could not load the jdbc driver. Please try again!");
		} catch (SQLException e) {

		}

	}
}

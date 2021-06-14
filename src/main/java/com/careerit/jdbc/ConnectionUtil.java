package com.careerit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionUtil {

	public Connection getConnection() {

		Connection con = null;
		try {
			Properties properties = new Properties();
			properties.load(ConnectionUtil.class.getResourceAsStream("/application.properties"));
			con = DriverManager.getConnection(properties.getProperty("db.url"), properties.getProperty("db.username"),
					properties.getProperty("db.password"));
		} catch (Exception e) {
			System.out.println("While connecting with db:" + e);
		}
		return con;
	}
}

package com.safee.DAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

public final class JdbcConnectionFactory {

	private static JdbcConnectionFactory connectionFactory;

	private Connection connection;

	private JdbcConnectionFactory() {

	}

	public static JdbcConnectionFactory createInstance() {
		if (connectionFactory == null) {
			connectionFactory = new JdbcConnectionFactory();
		}

		return connectionFactory;
	}

	public static Connection getConnection() {
		return createInstance().createConnection();
	}

	private Connection createConnection() {

		/*Properties credentialsProps = null;
		boolean error = true;
		try {
			// File file = new File("credentials.properties");
			credentialsProps = new Properties();
			// InputStream inStream = new FileInputStream(file);
			InputStream stream = ClassLoader.getSystemResourceAsStream("./config/database.properties");

			if (stream == null) {
				System.out.println("Error in loading the credentials for JDBC, "
						+ "credentials.properties file with jdbc credentials in the following foramt is required \n"
						+ "userName=userName\npassword=password");
				return null;
			}
			credentialsProps.load(stream);
			error = false;
		} catch (FileNotFoundException e1) {
			System.out.println("Null Stream");
			System.out.println("Error in loading the credentials for JDBC, "
					+ "credentials.properties file with jdbc credentials in the following foramt is required \n"
					+ "userName=userName\npassword=password");
		} catch (IOException e1) {
			System.out.println("Failed to load the file credentials.properties");
		}

		if (error) {
			return null;
		}
*/
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		

		String url = "jdbc:mysql://localhost:3306/employees?autoReconnect=true&useSSL=false";
		String user = "root";
		String password = "Ajke4dikekeun@i";
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}

}

package geekbitjava.test;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {

	public static void main(String[] args) {

		String jdbcUrl = "jdbc:mysql://www.papademas.net/ps?useSSL=false";
		String userName = "ps";
		String password = "ps1";

		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			Connection connection = DriverManager.getConnection(jdbcUrl, userName, password);
			System.out.println("Connection Successful!");
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

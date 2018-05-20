package databaseTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class testMain {

	public static void main(String[] args) throws Exception {

		Connection con = null;

		String dburl = "jdbc:mysql://localhost:3306/automationtesting?autoReconnect=true";
		String driver = "com.mysql.cj.jdbc.Driver";
		String userName = "root";
		String password = "root";

		Class.forName(driver).newInstance();
		con = DriverManager.getConnection(dburl, userName, password);

		System.out.println("Connection Established Successfully");

		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from credentials");

		while (rs.next()) {
			System.out.println("Username: " + rs.getString("Username") + 
			" -- Password: " + rs.getString("Password") + 
			" -- Date: " + rs.getString("DateCreated") + 
			" -- Attempts: " + rs.getString("NoOfAttempts") +
			" -- Result: " + rs.getString("Results")
			);
			
		}
		rs.close();
	}
}
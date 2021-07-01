package com.te.jdbc.assignment1;

import java.sql.SQLException;
import java.util.Properties;
import java.io.FileInputStream;
import java.sql.*;

public class SelectQuery {

	public static void main(String[] args) {
		Connection connection=null;
		Statement statement=null;
		try {
			FileInputStream file= new FileInputStream("directory.properties");
			Properties properties= new Properties();
			properties.load(file);
			String driver=properties.getProperty("driver");
			String dburl=properties.getProperty("dburl");
			String user=properties.getProperty("user");
			String password=properties.getProperty("password");
			String query=properties.getProperty("SelectOpe");
			Class.forName(driver); 
			
			connection = DriverManager.getConnection(dburl,user,password);
			
			statement=connection.createStatement();
			
			ResultSet resultSet=statement.executeQuery(query);
			
			while (resultSet.next()) {
				System.out.println("ID: " + resultSet.getInt(1));
				System.out.println("Name: " + resultSet.getString(2));
				System.out.println("Date: " + resultSet.getString(3));
				System.out.println("Address: " + resultSet.getString(4));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (connection != null)
					connection.close();
				
				if (statement!=null)
					statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

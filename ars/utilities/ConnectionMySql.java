package com.skps.ars.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMySql {
	
	public Connection getConnection(){
		Connection conn=null;
		 String url = "jdbc:mysql://localhost:3306/";
		    String dbName = "ars";
		    String driver = "com.mysql.jdbc.Driver";
		    String userName = "root"; 
		    String password = "myPassword1!";
	
		try {
		    String sql = "SELECT * FROM domesticaircraft";
		    	
		      Class.forName(driver).newInstance();
		      conn = DriverManager.getConnection(url+dbName,userName,password);
		      System.out.println("Connected to the database");
	} catch (SQLException e)
        {
        System.out.println( e.getMessage() );
    }
    
    catch (Exception e) {
      e.printStackTrace();
    }
		return conn;
	}
	
	public void destroyConnection(Connection conn){
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println( e.getMessage() );
		}
	}

}

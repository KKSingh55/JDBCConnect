package com.JDBCDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class DBDemo {
	static Connection connection =null;
	        static Statement statement = null;

	public static void main(String[] args) {
		
		try {
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "qafox";
		String bdUrl =url+dbName; 
		String username = "root";
		String password = "root";
		String QUERY = "select * from employeee2";
		
		//create an object for mySql JDBC driver class
		
		String driver ="com.mysql.cj.jdbc.Driver";
		Class.forName(driver).newInstance();
		
		//connect to mySql database System
		 connection = DriverManager.getConnection(bdUrl,username,password);
		
		//Verify the connection and execute SQL Statements
        if(!connection.isClosed()) {
			
			System.out.println("Successfully connected to qafox Database");
			
//			//Fire SQL Selection Statements
//			Statement statement = connection.createStatement();
//			ResultSet resultSet = statement.executeQuery("select * from Employeee");
//			
//			while(resultSet.next()) {
//				
//				System.out.println(resultSet.getString("Name")+"--"
//				                  +resultSet.getString("Location")+"--"
//						          +resultSet.getInt("Experience"));
//								
//			}
//		//Execute the queries to update the employee table records
//		Statement statement1 = connection.createStatement();
//		  String sql = "UPDATE employeee SET Experience = 8 WHERE Name = 'kk'";
//		  statement1.executeUpdate(sql);
//		 ResultSet ResultSet = statement1.executeQuery(QUERY);
//
//	while(ResultSet.next()) {
//			
//			System.out.println(ResultSet.getString("Name")+
//					  "--"+ResultSet.getString("Location")+
//					  "--"+ResultSet.getInt("Experience"));
//	      }
//		
//		// execute prepared statement to retrieve the filtered records from the employees
//		
//		PreparedStatement prepared =connection.prepareStatement("select * from employeee where Name =? and Experience =?");	
//		prepared.setString(1, "kanhaiya");
//		prepared.setInt(2, 3);
//		ResultSet ResultSets = prepared.executeQuery();
//		
//		while(ResultSets.next()) {
//			System.out.println(ResultSets.getString("Name")+
//					          "--"+ResultSets.getInt("Experience"));	
//			
//		} 
//			
			 Statement statement = connection.createStatement();
	       {		      
	          String sql = "CREATE TABLE employeee2 " +
	                   "(id INTEGER not NULL, " +
	                   " first VARCHAR(235), " + 
	                   " last VARCHAR(254), " + 
	                   " age INTEGER, " + 
	                   " empExp INTEGER,"+
	                   " PRIMARY KEY ( id ))"; 

	          statement.executeUpdate(sql);
		
		System.out.println("Inserting records into the table...");          
        String sql1 = "INSERT INTO employeee2 VALUES (100, 'Zara', 'Ali',4, 18)";
        statement.executeUpdate(sql1);
        sql = "INSERT INTO employeee2 VALUES (101, 'Mahnaz', 'Fatma',4 ,25)";
        statement.executeUpdate(sql);
        sql = "INSERT INTO employeee2 VALUES (102, 'Zaid', 'Khan',6, 30)";
        statement.executeUpdate(sql);
        sql = "INSERT INTO employeee2 VALUES(103, 'Sumit', 'Mittal',8, 28)";
        statement.executeUpdate(sql);
        System.out.println("Inserted records into the table...");  
        
        
        ResultSet ResultSet = statement.executeQuery(QUERY);
        
        	while(ResultSet.next()) {
        			
        			System.out.println(ResultSet.getInt("id")+
        					  "--"+ResultSet.getString("first")+
        					  "--"+ResultSet.getString("last")+
        					  "--"+ResultSet.getInt("age"));
		
		
//			 String sql = "DROP TABLE employeee1";
//			 try {
//				statement.executeUpdate(sql);
//			} catch (Exception e) {
//				
//				e.printStackTrace();
//			}
//	         System.out.println("Table deleted in given database...");
//		
//        
//		
//        } 
	       
        	}}}    }catch(Exception e)
		{
        	
        	e.printStackTrace();
        }
		
		finally {
		//Close the connection
		try {
			connection.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		try {
			if(connection.isClosed()) {
				
				System.out.println("Successfully closed the connection to qafox Database");
				
			}
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		}
}
}


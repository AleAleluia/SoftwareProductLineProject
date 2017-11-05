package database;

import java.sql.*;

public class JDBC {
	
	/*JDBC driver name and database URL*/
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/library";

	/*database credentials*/
	static final String USER = "root"; //username
	static final String PASS = "root"; //password
	
	public static void main(String[] args){
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); //register jdbc driver
			
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			System.out.println("Creating database...");
			stmt = conn.createStatement();
			
			//String db = "CREATE DATABASE library";
			//stmt.executeUpdate(db);
			
			/*String table = "CREATE TABLE books ("
					+ "id int NOT NULL,"
					+ "title varchar(255),"
					+ "author varchar(255),"
					+ "price float);";
			stmt.executeUpdate(table);*/
			
			String content = "INSERT INTO books (id, title, author, price)"
					+ " VALUES ('1', 'Cálculo Volume I', 'James Stewart', '84.90');" ;
			stmt.executeUpdate(content);
			
			content = "INSERT INTO books (id, title, author, price)"
					+ " VALUES ('2', 'Cálculo Volume II', 'James Stewart', '89.90');";
			stmt.executeUpdate(content);
			
			content = "INSERT INTO books (id, title, author, price)"
					+ " VALUES ('3', 'Fundamentos de Física Volume I', 'David Halliday, Robert Resnick', '109.90');";
			stmt.executeUpdate(content);
			
			content = "INSERT INTO books (id, title, author, price)"
					+ " VALUES ('4', 'Conceitos de Linguagem de Programação', 'Robert Sebesta', '125.90');";
			stmt.executeUpdate(content);
			
			content = "INSERT INTO books (id, title, author, price)"
					+ " VALUES ('5', 'Algoritmos - Teoria e Prática', 'Thomas Cormem', '282.90');";
			stmt.executeUpdate(content);
			
			content = "INSERT INTO books (id, title, author, price)"
					+ " VALUES ('6', 'Introdução a Programação com a Linguagem C', 'Rodrigo de Barros Paes', '55.90');";
			stmt.executeUpdate(content);
			
			content = "INSERT INTO books (id, title, author, price)"
					+ " VALUES ('7', 'Inteligência Artificial', 'Peter Norvig', '307.90');";
			stmt.executeUpdate(content);
			
			content = "INSERT INTO books (id, title, author, price)"
					+ " VALUES ('8', 'O Guia do Mochileiro das Galáxias', 'Douglas Adams', '19.90');";
			stmt.executeUpdate(content);
			
			content = "INSERT INTO books (id, title, author, price)"
					+ " VALUES ('9', 'Origem', 'Dan Brown', '49.90');";
			stmt.executeUpdate(content);
			
			content = "INSERT INTO books (id, title, author, price)"
					+ " VALUES ('10', 'O Mundo de Sofia', 'Jostein Gaarder', '39.90');";
			stmt.executeUpdate(content);
			
			System.out.println("Database created successfully!");
		} catch (SQLException se) {
			se.printStackTrace(); //handle errors for jdbc
		} catch (Exception e) {
			e.printStackTrace(); //handle errors for Class.forName
		} finally { //close resources
			try {
				if(stmt != null)
		            stmt.close();
			} catch(SQLException se2) {
				//nothing we can do
			}
			
			try {
				if(conn != null)
		            conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			 
		}
		
	}

}

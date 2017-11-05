package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import main.Book;

public class SearchEngine {
	private final String DB_URL = "jdbc:mysql://localhost/library";

	/*database credentials*/
	private final String USER = "root"; //username
	private final String PASS = "363436lm"; //password
	
	public Book getBookBy(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "SELECT * FROM books price WHERE id = " + id;
		try {
			conn = getDBConnection();
			stmt = conn.prepareStatement(sql);
			//stmt.setInt(1, 1001);
			
			ResultSet rs = stmt.executeQuery(); //execute sql statement
			
			while(rs.next()) {
				String title = rs.getString("title");
				String author = rs.getString("author");
				float price = rs.getFloat("price");
				return new Book(id, title, price);
			}
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		} finally {
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
		return null;
	}
	
	public List<Book> orderByPrice() {
		Connection conn = null;
		PreparedStatement stmt = null;
		List<Book> result = new ArrayList<Book>();
		
		String sql = "SELECT * FROM books ORDER BY price";
		
		try {
			conn = getDBConnection();
			stmt = conn.prepareStatement(sql);
			//stmt.setInt(1, 1001);
			
			ResultSet rs = stmt.executeQuery(); //execute sql statement
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				float price = rs.getFloat("price");
				result.add(new Book(id, title, price));
			}
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		} finally {
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
		return result;
	}
	
	public void orderByTitle() {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		String sql = "SELECT * FROM books ORDER BY title";
		
		try {
			
			
			conn = getDBConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, 1001);
			
			ResultSet rs = stmt.executeQuery(); //execute sql statement
						
			while(rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				float price = rs.getFloat("price");
			}
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		} finally {
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
	
	private Connection getDBConnection() {
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); //register jdbc driver
			
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		    return conn;
			
		} catch (SQLException se) {
			se.printStackTrace(); //handle errors for jdbc
		} catch (Exception e) {
			e.printStackTrace(); //handle errors for Class.forName
		} 
		/*
		finally { //close resources
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
		*/
		
		return conn;
	}
	
}

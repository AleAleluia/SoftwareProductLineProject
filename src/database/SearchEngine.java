package database;

import java.sql.*;

public class SearchEngine extends JDBC {
	
	
	public static void orderByPrice() {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		String sql = "SELECT * FROM books ORDER BY price";
		
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
	
	public static void orderByTitle() {
		
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
	
	private static Connection getDBConnection() {
		
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
		
		return conn;
	}
	
	
	public static void main(String[] args) {
		
		orderByTitle();
		
	}

}

package main;

import java.util.ArrayList;

public class User {
	String name;
	int id;
	String password;
	ArrayList<Book> shoppingCart = new ArrayList<Book>();
	
	public User(String userName, int userId, String userPassword){
		this.name = userName;
		this.id = userId;
		this.password = userPassword;
	}
	
	/* USER METHODS:
	 * - addToCart (add a book to shoppingCart)
	 * - buyBook (pick up shoppingCart and choose payment method)
	 * */
	

}

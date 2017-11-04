package main;

import java.util.ArrayList;
import java.util.Scanner;

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
	 * - showShoppingCart
	 * - buyBook (pick up shoppingCart and choose payment method)
	 * */
	
	public void addToCart(Book book, int quantity){
		for(int i=0; i<quantity; i++)
			this.shoppingCart.add(book);
		
	}
	
	public void showShoppingCart(){
		float sum=0;
		System.out.println("----------CARRINHO DE COMPRAS:----------");
		System.out.println("Lista de Livros: \n");
		for(int i=0; i<this.shoppingCart.size(); i++){
			System.out.println(this.shoppingCart.get(i).getName());
			sum += this.shoppingCart.get(i).getPrice();
		}
		System.out.printf("TOTAL A PAGAR: %f \n", sum);
	}
	
	public boolean buyBook(){
		float sum=0;
		for(int i=0; i<this.shoppingCart.size(); i++){
			sum += this.shoppingCart.get(i).getPrice();
		}
		System.out.printf("TOTAL A PAGAR: %f \n", sum);
		if(paymentMethod()){
			System.out.println("Pagamento realizado com sucesso!");
			this.shoppingCart.clear();
			return true;
		}
		return false;
	}
	
	public static boolean paymentMethod(){
		System.out.println("Qual o método de pagamento? \n" + "1 - PagSeguro \n" + "2 - Boleto \n" + "3 - Cartão de crédito");
		Scanner in = new Scanner(System.in);
		int choice = in.nextInt();
		boolean result = false;
		switch(choice){
			case 1:
				System.out.println("Coletando dados do PagSeguro");
				result = true;
				break;
			case 2:
				System.out.println("Gerando boleto");
				result = true;
				break;
			case 3:
				System.out.println("Coletando dados de cartão de crédito"); //can add more things here
				result = true;
				break;
			default:
				System.out.println("Opção inválida!");
				break;
		}
		return result;
	}
	

}

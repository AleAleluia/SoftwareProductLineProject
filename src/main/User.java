package main;

import java.util.ArrayList;
import java.util.Scanner;

import payment.PaymentMethods;
import properties.PropertiesLoaderVariability;

public class User {
	String name;
	int id;
	String password;
	ArrayList<Book> shoppingCart = new ArrayList<Book>();
	
	public User() {
		
	}
	
	public User(String userName, int userId, String userPassword){
		this.name = userName;
		this.id = userId;
		this.password = userPassword;
	}
	
	public void addToCart(Book book, int quantity){
		for(int i=0; i<quantity; i++)
			this.shoppingCart.add(book);
	}
	
	public float showShoppingCart(){
		float sum=0;
		System.out.println("----------CARRINHO DE COMPRAS:----------");
		System.out.println("Lista de Livros: \n");
		for(int i=0; i<this.shoppingCart.size(); i++){
			System.out.println(this.shoppingCart.get(i).getName());
			sum += this.shoppingCart.get(i).getPrice();
		}
		System.out.printf("TOTAL A PAGAR: %f \n", sum);
		final String layout = PropertiesLoaderVariability.getValor("layout");
		if (layout.equals("sale")) {
			String strSale = PropertiesLoaderVariability.getValor("sale");
			float sale = Float.parseFloat(strSale);
			sum = sum - (sum * sale);
			System.out.println("A loja esta com desconto de "+ sale + "%!!!");
			System.out.printf("TOTAL A PAGAR COM DESCONDO: %f \n", sum);
		}
		return sum;
	}
	
	public boolean buyBook(){
		float sum = showShoppingCart();
		if(paymentMethod(sum)){
			System.out.println("Pagamento realizado com sucesso!");
			this.shoppingCart.clear();
			return true;
		} else {
			System.out.println("Pagamento nao realizado!");
		}
		return false;
	}
	
	private boolean paymentMethod(float value){
		PaymentMethods payMethods = new PaymentMethods();
		payMethods.printPaymentMethods();
		
		Scanner in = new Scanner(System.in);
		int choice = in.nextInt();
		return payMethods.callPaymentMethods(new Integer(choice), value);
	}
}

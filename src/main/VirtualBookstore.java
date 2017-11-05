
package main;

import java.util.Scanner;

import properties.PropertiesLoaderVariability;

public class VirtualBookstore {

	private User user = new User();
	
	public void printSale() {
		final String layout = PropertiesLoaderVariability.getValor("layout");
		if (layout.equals("sale")) {
			String strSale = PropertiesLoaderVariability.getValor("sale");
			float sale = Float.parseFloat(strSale) * 100;
			System.out.println("A loja esta com desconto de "+ sale + "%!!!");
		}
	}
	
	public void menu() {
		Scanner in = new Scanner(System.in);
		int choice;
		System.out.println("Escolha sua acao");
		System.out.println("1 - Listar livros \n" + "2 - Comprar Livros no carrinho do usuario\n" 
				+ "3 - Adicionar livros no carrinho por id\n");
		choice = in.nextInt();
		switch(choice) {
			case 1:
				showBooks();
				break;
			case 2:
				buyBooks();
				break;
			case 3:
				addCart();
				break;
			default:
				System.out.println("Opcao invalida");
				break;
		}
		in.close();	
	}
	
	public void run() {
		printSale();
		menu();
	}
	
	/**
	 * Show all books
	 */
	public void showBooks() {
		
	}
	
	/**
	 * Buy books
	 */
	public void buyBooks() {
		
	}
	
	/**
	 * Adds books in cart
	 */
	public void addCart() {
		System.out.println("Digite o id do livro que voce deseja adicionar ao carrinho:");
		Scanner in = new Scanner(System.in);
		int id = in.nextInt();
		System.out.println("Qual a quantidade?");
		int quantity = in.nextInt();
		//Add
	}
}

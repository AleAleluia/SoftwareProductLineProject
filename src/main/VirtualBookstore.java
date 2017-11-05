package main;

import java.util.List;
import java.util.Scanner;

import database.SearchEngine;
import properties.PropertiesLoaderVariability;
import main.Book;
import main.User;

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
			case 4:
				return;
			default:
				System.out.println("Opcao invalida");
				break;
		}
		menu();
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
		SearchEngine searchEngine = new SearchEngine();
		List<Book> lBooks = searchEngine.orderByPrice();
		for (Book book : lBooks) {
			System.out.println("==========================");
			System.out.println("Id: " + book.getId());
			System.out.println("Título: " + book.getName());
			System.out.println("Preço: " + book.getPrice());
			System.out.println("==========================");
		}
	}
	
	/**
	 * Buy books
	 */
	public void buyBooks() {
		user.buyBook();
	}
	
	public Book getBookBy(int id) {
		SearchEngine searchEngine = new SearchEngine();
		List<Book> lBooks = searchEngine.orderByPrice();
		for (Book book : lBooks) {
			if (book.getId() == id) {
				return book;
			}
		}
		return null;
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
		SearchEngine se = new SearchEngine();
		this.user.addToCart(se.getBookBy(id), quantity);
	}
}

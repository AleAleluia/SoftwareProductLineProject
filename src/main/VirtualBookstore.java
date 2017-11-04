package main;

import java.util.Scanner;

import properties.PropertiesLoaderVariability;

public class VirtualBookstore {

	public static void main(String[] args) {
		
		final String layout = PropertiesLoaderVariability.getValor("layout");
		
		if (layout.equals("sale")) {
			String strSale = PropertiesLoaderVariability.getValor("sale");
			float sale = Float.parseFloat(strSale) * 100;
			System.out.println("A loja está com descondo de "+ sale + "%!!!");
		}
		
		Scanner in = new Scanner(System.in);
		int choice;
		System.out.println("Escolha o tipo de interface desejada");
		System.out.println("1 - Web \n" + "2 - Mobile");
		
		choice = in.nextInt();
		switch(choice){
			case 1:
				//showWebMenu
				break;
			case 2:
				//showMobileMenu
				break;
			default:
				System.out.println("Op��o inv�lida!");
				break;
		}
		in.close();	
	}
	
	/* VIRTUALBOOKSTORE METHODS:
	 * - showWebMenu (show the options inline)
	 * - showMobileMenu (show the options underneath)
	 * */
}

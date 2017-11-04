package main;

import java.util.Scanner;

public class VirtualBookstore {

	public static void main(String[] args) {
		
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
				System.out.println("Opção inválida!");
				break;
		}
			
	}
	
	/* VIRTUALBOOKSTORE METHODS:
	 * - showWebMenu (show the options inline)
	 * - showMobileMenu (show the options underneath)
	 * */
}

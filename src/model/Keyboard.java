/**
 * @author diego
 */
package model;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;


/* This class we had Raul's helps because our project was loaded of
Scanners and it was conflicting with among them, so Raul taught this methods */ 
public class Keyboard {
	
	public static String textInput(String prompt) {
		System.out.println(prompt);
		Scanner input = new Scanner(System.in);
		return input.nextLine();
	}
	public static int numberInput(String prompt) {
		
		System.out.println(prompt);
		int number = 0;
		
		try {
			Scanner input = new Scanner(System.in);
			number = input.nextInt();
		} catch(InputMismatchException e) {
			System.out.println("Enter only number!");
			numberInput(prompt);
		}
		return number;
	}
	
	public static void textOutput(String content) {
		JOptionPane.showMessageDialog(null, content);
	}

}

package net.zyang.io;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerInput {

	public ScannerInput() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
//		read next line
		System.out.print("Enter your name: ");
		String name = scanner.nextLine();
		System.out.println("Your name is " + name);
		
//		read next token
		System.out.print("Enter your gender: ");
		String gender = scanner.next();
//		clear buffer, and consumes the new line character (discard)
		scanner.nextLine();
		System.out.println("Your gender is " + gender);
		
//		read next int
		System.out.print("Enter your age: ");
		int age = scanner.nextInt();
//		clear buffer, and consumes the new line character (discard)
		scanner.nextLine();
		System.out.println("Your age is " + age);
		
//		next next token
		System.out.println("Input numbers, ending with '-1': ");
		int total = 0;
		int count = 0;
		while(scanner.hasNextInt()) {
			int current = scanner.nextInt();
			if (current != -1) {
				++count;
				total += current;
			} else {
				break;
			}
			
		}
//		clear buffer, and consumes the new line character (discard)
		scanner.nextLine();
		if (count > 0) {
			System.out.println("Average is: " + total * 1.0 / count);
		}
		
		boolean keepgoing = true;
		while(keepgoing) {
			try {
				System.out.println("Enter your age (integer): ");
				scanner.nextInt();
				keepgoing = false;
			} catch (InputMismatchException ime) {
				System.out.println("Wrong input, please try again.");
			} finally {
//				clear buffer, and consumes the new line character
				scanner.nextLine();
			}
		}
	}

}

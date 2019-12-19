package net.zyang.io;

import java.io.Console;

public class ConsoleInput {

	public ConsoleInput() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		Console console = System.console();
		
		if (console == null) {
			System.out.println("No console available");
			return;
		}
		
		String name = console.readLine("Enter your name: ");
		char[] password = console.readPassword("Enter your password: ");
		
		console.printf("Your name is: %20s", name);
		console.printf("Your password is: %20s", String.valueOf(password));
	}

}

package net.zyang.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderInput {

	public InputStreamReaderInput() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String line = null;
			
			while(!"".equals(line = br.readLine())) {
				System.out.println("You just inputed: " + line);
			}	
		}
	}

}

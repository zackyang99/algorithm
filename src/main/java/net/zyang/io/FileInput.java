package net.zyang.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileInput {

	public FileInput() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) throws Exception {
		String rootName = "";
		String fileName = "";
		Path rootPath = Paths.get(rootName);
		Path filePath = rootPath.resolve(fileName);
//		check if file exists
		if (!Files.exists(filePath)) {
			System.out.format("File %s not exists", filePath.toString());
			return;
		}
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath.toFile())))) {
			String line = null;
			
		}
	}
}

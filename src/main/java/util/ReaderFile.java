package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class ReaderFile {

	public static String extractTextFromFile(String link) throws IOException{

		File beansBase = new File(link);
		StringBuilder beansBaseStr = new StringBuilder();
		
		FileReader fileReader = new FileReader(beansBase);
		
		int symb;
		while ((symb = fileReader.read()) != -1) {			
			beansBaseStr.append((char) symb);			
		}
		fileReader.close();
		
		return beansBaseStr.toString();
	}
	
	public static ArrayList<String> getArrayLines(String linkFile) {
		ArrayList<String> result = new ArrayList<String>();
		 try (BufferedReader reader = new BufferedReader(
	                new InputStreamReader(
	                        new FileInputStream(linkFile), StandardCharsets.UTF_8))){
	            String line;
	            while ((line = reader.readLine()) != null) {
	            	result.add(line);
	            }
	        } catch (IOException e) {
	           System.out.println("ioErr");
	        }
		 return result;
	}
	
}

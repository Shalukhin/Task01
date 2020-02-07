package util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class ReaderFile {
	
	public static ArrayList<String> getArrayLines(String linkFile) {
		ArrayList<String> result = new ArrayList<String>();
		 try (BufferedReader reader = new BufferedReader(
	                new InputStreamReader(
	                        new FileInputStream(linkFile), StandardCharsets.UTF_8))){
	            String line;
	            while ((line = reader.readLine()) != null) {
	            	if (Validator.isValidParametersTour(ParserText.getArrayParametersFromLine(line))) {
	            		result.add(line);
	            	}	            	
	            }
	        } catch (IOException e) {
	           System.out.println("ioErr");
	        }
		 return result;
	}
	
}

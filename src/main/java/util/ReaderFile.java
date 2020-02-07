package util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import exception.ResourceException;

public class ReaderFile {
	
	public static ArrayList<String> getArrayLines(String linkFile) throws ResourceException {
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
	           throw new ResourceException("file_tours_error");
	        }
		 return result;
	}	
}

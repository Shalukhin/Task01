package util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DriversFile {

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
	
}

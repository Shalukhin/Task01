package util;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;

import entity.Cruise;
import entity.Excursion;
import entity.TypeOfTour;

public class Runner {
	
	public static void main(String[] args) throws IOException {
		
		ArrayList<String> s = ReaderFile.getArrayLines(ConstantsText.LINK_TOURS);
		
		for (String str : s) {
			System.out.println(str);
		}
		
		
		
	}

}

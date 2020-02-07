package util;

import java.util.ArrayList;

public class ParserText {
	
	public static ArrayList<String> getArrayParametersFromLine(String line){
		ArrayList<String> resultParamArr = new ArrayList<String>();
		
		String[] arr = line.split("\\|");
		for (int i = 0; i < arr.length; i++) {
			resultParamArr.add(arr[i].trim());
		}
		
		return resultParamArr;
		
	}

	
}

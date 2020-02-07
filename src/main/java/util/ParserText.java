package util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entity.TypeOfTour;
import entity.TypeOfTransportation;

public class ParserText {

	public static ArrayList<String> getArrayTagsFromTextByName(String text, String nameTag) {
		ArrayList<String> tagsArr = new ArrayList<String>();
		int start;
		int end;
		Pattern patternStartTag = Pattern.compile("<" + nameTag + ">");
		Matcher matcherStartTag = patternStartTag.matcher(text);
		Pattern patternEndTag = Pattern.compile("<\\/" + nameTag + ">");
		Matcher matcherEndTag = patternEndTag.matcher(text);
		while (matcherStartTag.find()) {
			start = matcherStartTag.end();
			if (matcherEndTag.find(start)) {
				end = matcherEndTag.start();
				tagsArr.add(text.substring(start, end).trim());
			}
		}

		return tagsArr;
	}
	
	public static ArrayList<String> getArrayParametersFromLine(String line){
		ArrayList<String> resultParamArr = new ArrayList<String>();
		
		String[] arr = line.split("\\|");
		for (int i = 0; i < arr.length; i++) {
			resultParamArr.add(arr[i].trim());
		}
		
		return resultParamArr;
		
		
	}

	public static ArrayList<String> getArrayParametersFromTag(String tag) {
		ArrayList<String> resultParamArr = new ArrayList<String>();
		
		ArrayList<String> tagValue;

		tagValue = ParserText.getArrayTagsFromTextByName(tag, "type");
		if (tagValue.size() == 0 || !Validator.isValidTypeOfTour(tagValue.get(0))) {
			return false;
		}
		type = TypeOfTour.valueOf(tagValue.get(0).toUpperCase());

		tagValue = ParserText.getArrayTagsFromTextByName(tag, "id");
		if (tagValue.size() == 0 || !Validator.isValidIdOfTour(tagValue.get(0))) {
			return false;
		}
		id = Integer.valueOf(tagValue.get(0));

		tagValue = ParserText.getArrayTagsFromTextByName(tag, "transportation");
		if (tagValue.size() == 0 || !Validator.isValidTransportationOfTour(tagValue.get(0))) {
			return false;
		}
		transportation = TypeOfTransportation.valueOf(tagValue.get(0).toUpperCase());

		tagValue = ParserText.getArrayTagsFromTextByName(tag, "amountOfDays");
		if (tagValue.size() == 0 || !Validator.isValidAmountOfDayOfTour(tagValue.get(0))) {
			return false;
		}
		amountOfDays = Integer.valueOf(tagValue.get(0));

		tagValue = ParserText.getArrayTagsFromTextByName(tag, "food");
		if (tagValue.size() == 0 || !Validator.isValidFoodOfTour(tagValue.get(0))) {
			return false;
		}
		food = tagValue.get(0).equals("yes");

		tagValue = ParserText.getArrayTagsFromTextByName(tag, "price");
		if (tagValue.size() == 0 || !Validator.isValidPriceOfTour(tagValue.get(0))) {
			return false;
		}
		price = new BigDecimal(tagValue.get(0));
	}
}

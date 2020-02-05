package util;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
}

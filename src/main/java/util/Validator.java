package util;

import java.math.BigDecimal;
import java.util.ArrayList;

import entity.TypeOfTour;
import entity.TypeOfTransportation;

public class Validator {
	
	public static boolean isValidParametersTour(ArrayList<String> param) {
		if (param.size() < 6) {
			return false;
		}
		if (!isValidTypeOfTour(param.get(0)) || 
				!isValidTransportationOfTour(param.get(1)) || 
				!isValidAmountOfDayOfTour(param.get(2)) || 
				!isValidFoodOfTour(param.get(3)) || 
				!isValidPriceOfTour(param.get(4)) ||
				!isValidSpecificInfoOfTour(param.get(4))){
			return false;
		}
		return true;		
	}	

	private static boolean isValidTypeOfTour(String typeStr) {
		try {
			TypeOfTour.valueOf(typeStr.toUpperCase());
		} catch (IllegalArgumentException e) {
			return false;
		}
		return true;
	}
	
	private static boolean isValidTransportationOfTour(String transportationStr) {
		try {
			TypeOfTransportation.valueOf(transportationStr.toUpperCase());
		} catch (IllegalArgumentException e) {
			return false;
		}
		return true;
	}
	
	private static boolean isValidAmountOfDayOfTour(String amountOfDaysStr) {		
		int amountOfDays;
		try {
			amountOfDays = Integer.valueOf(amountOfDaysStr);
		} catch (NumberFormatException e) {
			return false;
		}
		return amountOfDays > 0 ? true : false;
	}
	
	private static boolean isValidFoodOfTour(String foodStr) {		
		
		return ((foodStr.equals("yes") || foodStr.equals("no")) ? true : false);
	}	
	
	private static boolean isValidPriceOfTour(String priceStr) {		
		BigDecimal bd;
		try {
			bd = new BigDecimal(priceStr);
		} catch (NumberFormatException e) {
			return false;
		}
		return (bd.compareTo(new BigDecimal("0")) >= 0 ? true : false);
	}
	
	private static boolean isValidSpecificInfoOfTour(String infoStr) {
		return !infoStr.isEmpty();
	}	
}

package util;

import java.math.BigDecimal;

import entity.TypeOfTour;
import entity.TypeOfTransportation;

public class Validator {

	public static boolean isValidTypeOfTour(String typeStr) {
		try {
			TypeOfTour.valueOf(typeStr.toUpperCase());
		} catch (IllegalArgumentException e) {
			return false;
		}
		return true;
	}

	public static boolean isValidIdOfTour(String idStr) {		
		int id;
		try {
			id = Integer.valueOf(idStr);
		} catch (NumberFormatException e) {
			return false;
		}
		return id > 0 ? true : false;
	}
	
	public static boolean isValidTransportationOfTour(String transportationStr) {
		try {
			TypeOfTransportation.valueOf(transportationStr.toUpperCase());
		} catch (IllegalArgumentException e) {
			return false;
		}
		return true;
	}
	
	public static boolean isValidAmountOfDayOfTour(String amountOfDaysStr) {		
		int amountOfDays;
		try {
			amountOfDays = Integer.valueOf(amountOfDaysStr);
		} catch (NumberFormatException e) {
			return false;
		}
		return amountOfDays > 0 ? true : false;
	}
	
	public static boolean isValidFoodOfTour(String foodStr) {		
		
		return ((foodStr.equals("yes") || foodStr.equals("no")) ? true : false);
	}	
	
	public static boolean isValidPriceOfTour(String priceStr) {		
		BigDecimal bd;
		try {
			bd = new BigDecimal(priceStr);
		} catch (NumberFormatException e) {
			return false;
		}
		return (bd.compareTo(new BigDecimal("0")) >= 0 ? true : false);
	}
	
	
	
}

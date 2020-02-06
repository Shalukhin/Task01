package factory;

import java.math.BigDecimal;
import java.util.ArrayList;

import entity.Cruise;
import entity.Excursion;
import entity.Recovery;
import entity.Relaxation;
import entity.Shopping;
import entity.Tour;
import entity.TypeOfTour;
import entity.TypeOfTransportation;
import util.ParserText;
import util.Validator;

public class TourFactory {

	public Tour getTour(TypeOfTour type) {

		switch (type) {

		case CRUISE:
			return new Cruise();

		case EXCURSION:
			return new Excursion();
			
		case RECOVERY:
			return new Recovery();
			
		case RELAXATION:
			return new Relaxation();
			
		case SHOPPING:
			return new Shopping();
		}
		
		return null;
	}
	
	public Tour getTourWithXMLParameters(String parametersXML) {
		
		TypeOfTour type;
		int id;
		TypeOfTransportation transportation;
		int amountOfDays;
		boolean food;
		BigDecimal price;		
		
		ArrayList<String> tagArray;
		
		tagArray = ParserText.getArrayTagsFromTextByName(parametersXML, "type");
		if (tagArray.size() == 0 || !Validator.isValidTypeOfTour(tagArray.get(0))) {
			return null;
		}				
		type = TypeOfTour.valueOf(tagArray.get(0).toUpperCase());
		
		tagArray = ParserText.getArrayTagsFromTextByName(parametersXML, "id");
		if (tagArray.size() == 0 || !Validator.isValidIdOfTour(tagArray.get(0))) {
			return null;
		}				
		id = Integer.valueOf(tagArray.get(0));
		
		tagArray = ParserText.getArrayTagsFromTextByName(parametersXML, "transportation");
		if (tagArray.size() == 0 || !Validator.isValidTransportationOfTour(tagArray.get(0))) {
			return null;
		}				
		transportation = TypeOfTransportation.valueOf(tagArray.get(0).toUpperCase());
		
		tagArray = ParserText.getArrayTagsFromTextByName(parametersXML, "amountOfDays");
		if (tagArray.size() == 0 || !Validator.isValidAmountOfDayOfTour(tagArray.get(0))) {
			return null;
		}				
		amountOfDays = Integer.valueOf(tagArray.get(0));
		
		tagArray = ParserText.getArrayTagsFromTextByName(parametersXML, "food");
		if (tagArray.size() == 0 || !Validator.isValidFoodOfTour(tagArray.get(0))) {
			return null;
		}				
		food = tagArray.get(0).equals("yes");
		
		tagArray = ParserText.getArrayTagsFromTextByName(parametersXML, "price");
		if (tagArray.size() == 0 || !Validator.isValidPriceOfTour(tagArray.get(0))) {
			return null;
		}				
		price = new BigDecimal(tagArray.get(0));
		
		Tour resultTour = new Tour();
		
		switch (type) {
		case CRUISE:
			Cruise cruise = (Cruise) resultTour;
			
			tagArray = ParserText.getArrayTagsFromTextByName(parametersXML, "routeOfCruise");
			if (tagArray.size() > 0) {
				cruise.setRouteOfCruise(tagArray.get(0));
			} else {
				cruise.setRouteOfCruise("none");
			}			
			break; 

		case EXCURSION:
			Excursion excursion = (Excursion) resultTour;
			
			tagArray = ParserText.getArrayTagsFromTextByName(parametersXML, "city");
			if (tagArray.size() > 0) {
				excursion.setCity(tagArray.get(0));
			} else {
				excursion.setCity("none");
			}			
			break; 
			
		case RECOVERY:
			return new Recovery();
			
		case RELAXATION:
			return new Relaxation();
			
		case SHOPPING:
			return new Shopping();
		}
		
		resultTour.setType(type);
		
		
	}

}

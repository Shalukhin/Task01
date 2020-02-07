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

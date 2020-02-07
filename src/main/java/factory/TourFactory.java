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
	
	public Tour getTour(ArrayList<String> parameters) {
		
		TypeOfTour type = TypeOfTour.valueOf(parameters.get(0));
		
		Tour resultTour = getTour(type);
		
		resultTour.setTransportation(TypeOfTransportation.valueOf(parameters.get(1)));
		resultTour.setAmountOfDays(Integer.valueOf(parameters.get(2)));
		resultTour.setFood(parameters.get(3).equals("yes"));
		resultTour.setPrice(new BigDecimal(parameters.get(4)));
		
		switch (type) {
		case CRUISE:
			Cruise cruise = (Cruise) resultTour;
			cruise.setRouteOfCruise(parameters.get(5));
			return cruise;

		case EXCURSION:
			Excursion excursion = (Excursion) resultTour;
			excursion.setCity(parameters.get(5));
			return excursion;
			
		case RECOVERY:
			Recovery recovery = (Recovery) resultTour;
			recovery.setIllness(parameters.get(5));
			return recovery;
			
		case RELAXATION:
			Relaxation relaxation = (Relaxation) resultTour;
			relaxation.setCountry(parameters.get(5));
			return relaxation;
			
		case SHOPPING:
			Shopping shopping = (Shopping) resultTour;
			shopping.setShop(parameters.get(5));
			return shopping;
		}
		
		return null;
	}

}

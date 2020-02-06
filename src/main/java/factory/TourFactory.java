package factory;

import entity.Cruise;
import entity.Excursion;
import entity.Recovery;
import entity.Relaxation;
import entity.Shopping;
import entity.Tour;
import entity.TypeOfTour;

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

}

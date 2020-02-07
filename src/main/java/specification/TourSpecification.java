package specification;

import entity.Tour;
import entity.TypeOfTour;
import entity.TypeOfTransportation;

public enum TourSpecification implements Specification<Tour> {
	FIND_ALL {
		@Override
		public boolean specified(Tour tour) {
			return true;
		}
	},

	FIND_ALL_CRUISE {
		@Override
		public boolean specified(Tour tour) {
			return tour.getType().equals(TypeOfTour.CRUISE);
		}
	},

	FIND_ALL_RECOVERY {
		@Override
		public boolean specified(Tour tour) {
			return tour.getType().equals(TypeOfTour.RECOVERY);
		}
	},

	FIND_ALL_RELAXATION {
		@Override
		public boolean specified(Tour tour) {
			return tour.getType().equals(TypeOfTour.RELAXATION);
		}
	},

	FIND_ALL_SHOPPING {
		@Override
		public boolean specified(Tour tour) {
			return tour.getType().equals(TypeOfTour.SHOPPING);
		}
	},

	FIND_ALL_TOUR_WITH_AIR_TRANSPORTATION {
		@Override
		public boolean specified(Tour tour) {
			return tour.getTransportation().equals(TypeOfTransportation.AIR);
		}
	},

	FIND_ALL_TOUR_WITH_FOOD_INCLUDING {
		@Override
		public boolean specified(Tour tour) {
			return tour.isFood();
		}
	};
	
	
	@Override
	public abstract boolean specified(Tour obj);

}

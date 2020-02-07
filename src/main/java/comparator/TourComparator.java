package comparator;

import java.util.Comparator;

import entity.Tour;

public enum TourComparator implements Comparator<Tour> {
	PRICE_INCREASE {
		@Override
		public int compare(Tour arg0, Tour arg1) {
			return arg0.getPrice().compareTo(arg1.getPrice());
		}
	},
	
	AMOUNT_DAY_INCREASE {
		@Override
		public int compare(Tour arg0, Tour arg1) {
			if (arg0.getAmountOfDays() > arg1.getAmountOfDays()) {
				return 1;
			} else if (arg0.getAmountOfDays() < arg1.getAmountOfDays()) {
				return -1;
			} else {
				return 1;
			}
		}
	}
	;

	@Override
	public abstract int compare(Tour arg0, Tour arg1);

}

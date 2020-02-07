package specification;

import entity.Tour;

public enum TourSpecification implements Specification<Tour> {
	FIND_ALL {
		@Override
		public boolean specified(Tour obj) {			
			return true;
		}
	};

	@Override
	public abstract boolean specified(Tour obj);


}

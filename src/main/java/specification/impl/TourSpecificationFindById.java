package specification.impl;

import entity.Tour;
import specification.Specification;

public class TourSpecificationFindById implements Specification<Tour> {
	
	private int id;
	
	public TourSpecificationFindById(int id) {
		super();
		this.id = id;
	}	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public boolean specified(Tour obj) {
		if (obj.getId() == id) {
			return true;
		}
		return false;
	}

}

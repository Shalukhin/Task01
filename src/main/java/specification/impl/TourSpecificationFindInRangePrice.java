package specification.impl;

import java.math.BigDecimal;

import entity.Tour;
import specification.Specification;

public class TourSpecificationFindInRangePrice implements Specification<Tour>{
	
	private double min;
	private double max;
	
	public TourSpecificationFindInRangePrice(double min, double max) {
		super();
		this.min = min;
		this.max = max;
	}

	public double getMin() {
		return min;
	}

	public void setMin(double min) {
		this.min = min;
	}

	public double getMax() {
		return max;
	}

	public void setMax(double max) {
		this.max = max;
	}

	@Override
	public boolean specified(Tour tour) {
		return (tour.getPrice().compareTo(BigDecimal.valueOf(min)) == 1 && tour.getPrice().compareTo(BigDecimal.valueOf(max)) == -1);
	}
	

}

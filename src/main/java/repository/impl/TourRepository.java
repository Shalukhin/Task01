package repository.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import entity.tour.Tour;
import entity.tour.TypeOfTour;
import repository.Repository;
import util.Specification;
import util.Validator;
import util.exception.RepositoryException;

public class TourRepository implements Repository<Tour> {

	private Set<Tour> tours;

	public TourRepository() {
		super();
		tours = new HashSet<Tour>();
	}

	public boolean save(Tour tour) throws RepositoryException {
		if (Validator.isNullValue(tour)) {
			throw new RepositoryException("add_null_tour_to_repository");
		}

		return tours.add(tour);
	}

	public Collection<Tour> getAll() {

		return tours;
	}

	public boolean delete(Tour tour) {

		return tours.remove(tour);
	}
	
	public Collection<Tour> find(Specification<Tour> specification) {
		Set<Tour> result = new HashSet<Tour>();
		for (Tour existTour : tours) {
			if (specification.specified(existTour)) {
				result.add(existTour);
			}
		}
		return result;
	}


	public Tour findTourById(final int id) throws RepositoryException {	
		
		Specification<Tour> specification = new Specification<Tour>() {			
			public boolean specified(Tour tour) {
				if (tour.getId() == id) {
					return true;
				}
				return false;
			}
		};
		
		Set<Tour> result = (Set<Tour>) find(specification);
		
		if (result.size() == 0) {
			throw new RepositoryException("tour_not_found");
		}
		
		return (Tour) result.toArray()[0];
	}

	public Collection<Tour> findToursByType(final TypeOfTour type) {
		Comparable<Tour> compare = new Comparable<Tour>() {			
			public int compareTo(Tour o) {
				if (o.getType().equals(type)) {
					return 0;
				}
				return 1;
			}
		};
		
		return find(compare);
	}

	

}

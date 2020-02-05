package repository.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import entity.tour.Tour;
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
			throw new RepositoryException("add_null_tour");
		}

		return tours.add(tour);
	}
	
	public Collection<Tour> find(Specification<Tour> specification) throws RepositoryException {
		if (Validator.isNullValue(specification)) {
			throw new RepositoryException("find_null_specification_tour");
		}
		Set<Tour> result = new HashSet<Tour>();
		for (Tour existTour : tours) {
			if (specification.specified(existTour)) {
				result.add(existTour);
			}
		}
		if (result.size() == 0) {
			throw new RepositoryException("tours_not_found");
		}
		return result;
	}

	public Collection<Tour> getAll() {

		return tours;
	}

	public boolean delete(Tour tour) throws RepositoryException {
		if (Validator.isNullValue(tour)) {
			throw new RepositoryException("delete_null_tour");
		}

		return tours.remove(tour);
	}
	
	
	public boolean update(final Tour tourUpdate) throws RepositoryException {
		if (Validator.isNullValue(tourUpdate)) {
			throw new RepositoryException("update_null_tour");
		}
		Tour deleteTour = (Tour) find(new Specification<Tour>() {			
			
			public boolean specified(Tour tour) {
				if (tour.getId() == tourUpdate.getId()) {
					return true;
				}
				return false;
			}
		}).toArray()[0];
		
		if(delete(deleteTour)) {
			return save(tourUpdate);
		} else {
			return false;
		}		
	}



//	public Tour findTourById(final int id) throws RepositoryException {	
//		
//		Specification<Tour> specification = new Specification<Tour>() {			
//			public boolean specified(Tour tour) {
//				if (tour.getId() == id) {
//					return true;
//				}
//				return false;
//			}
//		};
//		
//		Set<Tour> result = (Set<Tour>) find(specification);
//		
//		if (result.size() == 0) {
//			throw new RepositoryException("tour_not_found");
//		}
//		
//		return (Tour) result.toArray()[0];
//	}
//
//	public Collection<Tour> findToursByType(final TypeOfTour type) throws RepositoryException {
//		Specification<Tour> specification = new Specification<Tour>() {			
//			public boolean specified(Tour tour) {
//				if (tour.getType().equals(type)) {
//					return true;
//				}
//				return false;
//			}
//		};
//		
//		return find(specification);
//	}

	
	

}

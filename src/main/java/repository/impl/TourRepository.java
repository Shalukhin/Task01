package repository.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import entity.tour.Tour;
import repository.Repository;
import util.Specification;
import util.exception.RepositoryException;

public class TourRepository implements Repository<Tour> {

	private Set<Tour> tours;

	private TourRepository() {
		super();
		tours = new HashSet<Tour>();
	}
	
	private static class SingletonHolder{
		private final static TourRepository instance = new TourRepository();
	}
	
	public static TourRepository getInstance() {
		return TourRepository.SingletonHolder.instance;
	}

	public boolean save(Tour tour) throws RepositoryException {
		if (tour == null) {
			throw new RepositoryException("add_null_tour");
		}

		return tours.add(tour);
	}
	
	public Collection<Tour> find(Specification<Tour> specification) throws RepositoryException {
		if (specification == null) {
			throw new RepositoryException("null_specification_tour");
		}
		Set<Tour> result = new HashSet<Tour>();
		for (Tour existTour : tours) {
			if (specification.specified(existTour)) {
				result.add(existTour);
			}
		}		
		return result;
	}

	public boolean delete(Tour tour) throws RepositoryException {
		if (tour == null) {
			throw new RepositoryException("delete_null_tour");
		}
		return tours.remove(tour);
	}
	
	
	public boolean update(final Tour tourUpdate) throws RepositoryException {
		if (tourUpdate == null) {
			throw new RepositoryException("update_null_tour");
		}
		Tour tourExist = null; 
		for (Tour tour : tours) {
			if (tour.getId() == tourUpdate.getId()) {
				tourExist = tour;
				break;
			}
		}
		
		return delete(tourExist) ? save(tourUpdate) : false;	
		
	}

}

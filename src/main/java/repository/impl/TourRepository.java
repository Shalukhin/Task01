package repository.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import entity.Tour;
import repository.Repository;
import util.Specification;
import util.exception.RepositoryException;

public class TourRepository implements Repository<Tour> {

	private Set<Tour> tourCollection;

	private TourRepository() {
		super();
		tourCollection = new HashSet<Tour>();
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

		return tourCollection.add(tour);
	}
	
	public Collection<Tour> find(Specification<Tour> specification) throws RepositoryException {
		if (specification == null) {
			throw new RepositoryException("null_specification_tour");
		}
		Set<Tour> result = new HashSet<Tour>();
		for (Tour existTour : tourCollection) {
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
		return tourCollection.remove(tour);
	}
	
	
	public boolean update(final Tour tourUpdate) throws RepositoryException {
		if (tourUpdate == null) {
			throw new RepositoryException("update_null_tour");
		}
		Tour tourExist = null; 
		for (Tour tour : tourCollection) {
			if (tour.getId() == tourUpdate.getId()) {
				tourExist = tour;
				break;
			}
		}		
		return delete(tourExist) ? save(tourUpdate) : false;		
	}

}

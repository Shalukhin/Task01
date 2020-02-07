package repository.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import entity.Tour;
import exception.RepositoryException;
import repository.Repository;
import util.Specification;

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
		
		return tourCollection.add(tour);
	}
	
	public Collection<Tour> find(Specification<Tour> specification) throws RepositoryException {
		
		Set<Tour> result = new HashSet<Tour>();
		for (Tour existTour : tourCollection) {
			if (specification.specified(existTour)) {
				result.add(existTour);
			}
		}		
		return result;
	}

	public boolean delete(Tour tour) throws RepositoryException {
		
		return tourCollection.remove(tour);
	}
	
	
	public boolean update(final Tour tourUpdate) throws RepositoryException {
		
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

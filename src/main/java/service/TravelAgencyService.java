package service;


import java.util.ArrayList;
import entity.Tour;
import exception.ResourceException;
import exception.ServiceException;
import factory.RepositoryFactory;
import factory.TourFactory;
import repository.Repository;
import specification.TourSpecification;
import util.ConstantsText;
import util.ReaderFile;
import util.ParserText;

public class TravelAgencyService {
	
	private RepositoryFactory repositoryFactory = RepositoryFactory.getInstance();
	private TourFactory tourFactory = TourFactory.getInsance();
	
	private Repository<Tour> tourRepository = repositoryFactory.getTourRepository();
	
	public void refreashTourRepositoryFromFile() throws ServiceException {
		
		ArrayList<String> toursStrFromFile = null;
		try {
			toursStrFromFile = ReaderFile.getArrayLines(ConstantsText.LINK_TOURS);
		} catch (ResourceException e) {
			throw new ServiceException("filling_repository_error");
		}
		
		for (String tourStr : toursStrFromFile) {
			Tour tour = tourFactory.getTour(ParserText.getArrayParametersFromLine(tourStr));			
			tourRepository.save(tour);			
		}		
	}
	
	public ArrayList<Tour> getAllTour(){
		return new ArrayList<Tour>(tourRepository.find(TourSpecification.FIND_ALL));
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

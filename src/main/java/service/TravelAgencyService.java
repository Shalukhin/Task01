package service;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import entity.Tour;
import exception.ResourceException;
import exception.ServiceException;
import factory.RepositoryFactory;
import factory.TourFactory;
import repository.Repository;
import specification.Specification;
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
	
	public ArrayList<Tour> getAllCruise(){
		return new ArrayList<Tour>(tourRepository.find(TourSpecification.FIND_ALL_CRUISE));
	}
	
	public ArrayList<Tour> getAllToursWithFoodIncluding(){
		return new ArrayList<Tour>(tourRepository.find(TourSpecification.FIND_ALL_TOUR_WITH_FOOD_INCLUDING));
	}
	
	public ArrayList<Tour> getAllToursWithAirTransportation(){
		return new ArrayList<Tour>(tourRepository.find(TourSpecification.FIND_ALL_TOUR_WITH_AIR_TRANSPORTATION));
	}
	
	public Tour getTuorById(int id) throws ServiceException {
		Specification<Tour> specification = new Specification<Tour>() {			
			@Override
			public boolean specified(Tour tour) {				
				return (tour.getId() == id);
			}
		};
		Collection<Tour> findResult = tourRepository.find(specification);
		if (findResult.size() == 0) {
			throw new ServiceException("tour_not_found");
		}
		return (Tour) findResult.toArray()[0];
	}
	
	public ArrayList<Tour> getToursInRangePrice(double min, double max) throws ServiceException{
		Specification<Tour> specification = new Specification<Tour>() {			
			@Override
			public boolean specified(Tour tour) {
				return (tour.getPrice().compareTo(BigDecimal.valueOf(min)) == 1 && tour.getPrice().compareTo(BigDecimal.valueOf(max)) == -1);
			}
		};
		
		Collection<Tour> findResult = tourRepository.find(specification);
		if (findResult.size() == 0) {
			throw new ServiceException("tours_not_found");
		}
		return new ArrayList<Tour>(findResult) ;		
	}
	

}

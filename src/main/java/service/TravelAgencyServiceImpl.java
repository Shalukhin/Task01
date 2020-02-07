package service;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import entity.Tour;
import exception.ResourceException;
import exception.ServiceException;
import factory.RepositoryFactory;
import factory.TourFactory;
import repository.Repository;
import specification.Specification;
import specification.impl.TourSpecificationStandartSearch;
import specification.impl.TourSpecificationFindById;
import specification.impl.TourSpecificationFindInRangePrice;
import util.ConstantsText;
import util.ReaderFile;
import util.ParserText;

public class TravelAgencyServiceImpl implements TravelAgencyService {
	
	private static TravelAgencyServiceImpl instance = new TravelAgencyServiceImpl();
	
	private RepositoryFactory repositoryFactory = RepositoryFactory.getInstance();
	private TourFactory tourFactory = TourFactory.getInsance();	
	private Repository<Tour> tourRepository = repositoryFactory.getTourRepository();
	
	private TravelAgencyServiceImpl() {};
	
	public static TravelAgencyServiceImpl getInstance() {
		return instance;
	}
	
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
		return new ArrayList<Tour>(tourRepository.find(TourSpecificationStandartSearch.FIND_ALL));
	}
	
	public ArrayList<Tour> getAllCruise(){
		return new ArrayList<Tour>(tourRepository.find(TourSpecificationStandartSearch.FIND_ALL_CRUISE));
	}
	
	public ArrayList<Tour> getAllToursWithFoodIncluding(){
		return new ArrayList<Tour>(tourRepository.find(TourSpecificationStandartSearch.FIND_ALL_TOUR_WITH_FOOD_INCLUDING));
	}
	
	public ArrayList<Tour> getAllToursWithAirTransportation(){
		return new ArrayList<Tour>(tourRepository.find(TourSpecificationStandartSearch.FIND_ALL_TOUR_WITH_AIR_TRANSPORTATION));
	}
	
	public Tour getTourById(final int id) throws ServiceException {
		Specification<Tour> specification = new TourSpecificationFindById(id);
		Collection<Tour> findResult = tourRepository.find(specification);
		if (findResult.size() == 0) {
			throw new ServiceException("tour_not_found");
		}
		return (Tour) findResult.toArray()[0];
	}
	
	public ArrayList<Tour> getToursInRangePrice(final double min, final double max) throws ServiceException{
		Specification<Tour> specification = new TourSpecificationFindInRangePrice(min, max);
		Collection<Tour> findResult = tourRepository.find(specification);
		if (findResult.size() == 0) {
			throw new ServiceException("tours_not_found");
		}
		return new ArrayList<Tour>(findResult) ;		
	}
	
	public ArrayList<Tour> getSortTours(Comparator<Tour> comparator){
		ArrayList<Tour> allTours = getAllTour();
		return quickSort(allTours, comparator);
		
	}
	
	private ArrayList<Tour> quickSort(ArrayList<Tour> collect, Comparator<Tour> comparator){
		if (collect.size() < 2) {
			return collect;
		}
		Tour middle = collect.get(0);
		ArrayList<Tour> less = new ArrayList<Tour>();
		ArrayList<Tour> more = new ArrayList<Tour>();
		
		for (int i = 1; i < collect.size(); i++) {
			if (comparator.compare(collect.get(i), middle) == -1) {
				less.add(collect.get(i));
			} else {
				more.add(collect.get(i));
			}
		}
		
		return composite(quickSort(less, comparator), middle, quickSort(more, comparator));
		
	}
	private ArrayList<Tour> composite (ArrayList<Tour> less, Tour middle, ArrayList<Tour> more){
		ArrayList<Tour> resultCollect = new ArrayList<Tour>();
		resultCollect.addAll(less);
		resultCollect.add(middle);
		resultCollect.addAll(more);
		
		return resultCollect;
	}

}

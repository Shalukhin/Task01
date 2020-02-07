package service;

import java.io.IOException;
import java.util.ArrayList;

import entity.Client;
import entity.Order;
import entity.Tour;
import exception.ServiceException;
import factory.RepositoryFactory;
import repository.EntityRepository;
import repository.impl.TourRepository;
import util.ConstantsText;
import util.ReaderFile;
import util.ParserText;

public class TravelAgencyService {
	
	private TourRepository tours = TourRepository.getInstance();
	
	public void refreashTourRepositoryFromFile() throws ServiceException {
		
		String tourBaseStr = "";
		try {
			tourBaseStr = ReaderFile.extractTextFromFile(ConstantsText.LINK_TOURS);
		} catch (IOException e) {
			throw new ServiceException("file_tours_error");
		}
		
		ArrayList<String> toursStr = ParserText.getArrayTagsFromTextByName(tourBaseStr, "tour");
		for (int i = 0; i < toursStr.size(); i++) {
			
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

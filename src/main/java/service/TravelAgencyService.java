package service;

import java.io.IOException;
import java.util.ArrayList;

import entity.Client;
import entity.Order;
import entity.tour.Tour;
import factory.FactoryRepository;
import repository.EntityRepository;
import util.ConstantsText;
import util.DriversFile;
import util.ParserText;
import util.exception.ServiceException;

public class TravelAgencyService {
	
	FactoryRepository factoryRepository = FactoryRepository.getInstance();
	
	EntityRepository<Tour> tours = factoryRepository.getTourRepository();
	EntityRepository<Client> clients = factoryRepository.getClientRepository();
	EntityRepository<Order> orders = factoryRepository.getOrderRepository();
	
	public void refreashTourRepository() throws ServiceException {
		
		String tourBaseStr = "";
		try {
			tourBaseStr = DriversFile.extractTextFromFile(ConstantsText.LINK_TOURS);
		} catch (IOException e) {
			throw new ServiceException("file_tours_error");
		}
		
		ArrayList<String> toursStr = ParserText.getArrayTagsFromTextByName(tourBaseStr, "tour");
		for (int i = 0; i < toursStr.size(); i++) {
			
		}
		
	}
	

}

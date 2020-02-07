package service;


import java.util.ArrayList;
import java.util.Comparator;
import entity.Tour;
import exception.ServiceException;

public interface TravelAgencyService {

	public void refreashTourRepositoryFromFile() throws ServiceException;

	public ArrayList<Tour> getAllTour();

	public ArrayList<Tour> getAllCruise();

	public ArrayList<Tour> getAllToursWithFoodIncluding();

	public ArrayList<Tour> getAllToursWithAirTransportation();

	public Tour getTourById(final int id) throws ServiceException;

	public ArrayList<Tour> getToursInRangePrice(final double min, final double max) throws ServiceException;

	public ArrayList<Tour> getSortTours(Comparator<Tour> comparator);

}

package service;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import org.junit.Test;
import entity.Cruise;
import entity.Excursion;
import entity.Recovery;
import entity.Relaxation;
import entity.Shopping;
import entity.Tour;
import entity.TypeOfTransportation;
import exception.ServiceException;
import factory.ServiceFactory;

public class TravelAgencyServiceTest {
	
	private ArrayList<Tour> tourCollection = new ArrayList<>();
	private ServiceFactory serviceFactory = ServiceFactory.getInstance();
	private TravelAgencyService travelAgencyService = serviceFactory.getTravelAgencyService();
	
	
	public void testInitialCollectionTour() throws ServiceException {
		travelAgencyService.refreashTourRepositoryFromFile();
		
		Excursion excursion =  new Excursion(2, TypeOfTransportation.BUS, false, BigDecimal.valueOf(250), "Moscow");
		excursion.setId(2);
		tourCollection.add(excursion);
		Shopping shopping = new Shopping(1, TypeOfTransportation.BUS, false, BigDecimal.valueOf(100), "Ikea");
		shopping.setId(5);
		tourCollection.add(shopping);
		Recovery recovery = new Recovery(30, TypeOfTransportation.AIR, true, BigDecimal.valueOf(4000), "osteochondrosis");
		recovery.setId(3);
		tourCollection.add(recovery);
		Relaxation relaxation = new Relaxation(14, TypeOfTransportation.REAL, true, BigDecimal.valueOf(1500), "Turkey");
		relaxation.setId(4);
		tourCollection.add(relaxation);		
		Cruise cruise = new Cruise(12, TypeOfTransportation.SEA, true, BigDecimal.valueOf(2000), "Italy - Cyprus");
		cruise.setId(1);
		tourCollection.add(cruise);
				
	}
	
	@Test
	public void testGetAllTour() {		
		assertEquals(tourCollection, travelAgencyService.getAllTour());
	}	
	
	@Test
	public void testGetAllCruise() throws ServiceException {
		travelAgencyService.refreashTourRepositoryFromFile();
		Cruise cruise1 = new Cruise(12, TypeOfTransportation.SEA, true, BigDecimal.valueOf(2000), "Italy - Cyprus");
		cruise1.setId(13);		
		ArrayList<Tour> expected = new ArrayList<>();		
		expected.add(cruise1);
		System.out.println(expected);
		System.out.println(travelAgencyService.getAllCruise());
		assertEquals(expected, travelAgencyService.getAllCruise());
	}
	
	@Test
	public void testGetTourById() throws ServiceException {		
		travelAgencyService.refreashTourRepositoryFromFile();		
		Cruise expected = new Cruise(12, TypeOfTransportation.SEA, true, BigDecimal.valueOf(2000), "Italy - Cyprus");
		expected.setId(13);				
		assertEquals(expected, travelAgencyService.getTourById(13));
	}	

}

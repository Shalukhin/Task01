package factory;

import service.TravelAgencyService;
import service.TravelAgencyServiceImpl;

public class ServiceFactory {
	
	private static ServiceFactory instance = new ServiceFactory();
	
	private ServiceFactory() {};
	
	public static ServiceFactory getInstance() {
		return instance; 
	}			
	
	private TravelAgencyService travelAgencyService; 
	
	public TravelAgencyService getTravelAgencyService() {
		if (travelAgencyService == null) {
			travelAgencyService =TravelAgencyServiceImpl.getInstance();
		}
		return travelAgencyService;
	}

}

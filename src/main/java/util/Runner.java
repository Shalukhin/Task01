package util;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;

import entity.Cruise;
import entity.Excursion;
import entity.Tour;
import entity.TypeOfTour;
import exception.ResourceException;
import exception.ServiceException;
import service.TravelAgencyService;

public class Runner {
	
	public static void main(String[] args) throws IOException, ResourceException, ServiceException {
		
		TravelAgencyService agency = new TravelAgencyService();
		
		agency.refreashTourRepositoryFromFile();
		
		for (Tour tour : agency.getAllTour()) {
			System.out.println(tour);
		}
		
		
		
	}

}

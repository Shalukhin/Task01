package factory;

import entity.Tour;
import repository.Repository;
import repository.impl.TourRepository;

public class RepositoryFactory {
	
	private static RepositoryFactory instance = new RepositoryFactory();
	
	private Repository<Tour> tourRepository;
	
	private RepositoryFactory() {};
	public static RepositoryFactory getInstance() {
		return instance;
	}
	
	public Repository<Tour> getTourRepository() {
		if (tourRepository == null) {
			tourRepository = TourRepository.getInstance();
		}
		return tourRepository;
	}	

}

package factory;

import entity.Client;
import entity.Order;
import entity.tour.Tour;
import repository.EntityRepository;
//import repository.Repository;
//import repository.impl.ClientRepository;
//import repository.impl.OrderRepository;
//import repository.impl.TourRepository;

public class RepositoryFactory {
	
	private final static RepositoryFactory instance = new RepositoryFactory();
	
//	private final Repository<Tour> tourRepository = new TourRepository();	
//	private final Repository<Client> clientRepository = new ClientRepository();
//	private final Repository<Order> orderRepository = new OrderRepository();
	
	
	private RepositoryFactory() {};
	
	public static RepositoryFactory getInstance() {
		return instance;
	}
	
	public EntityRepository<Tour> getTourRepository() {
		if (tourRepository == null) {
			tourRepository = new EntityRepository<Tour>();
		}
		return tourRepository;
	}
	
	public EntityRepository<Client> getClientRepository() {
		if
		return clientRepository;
	}
	
	public EntityRepository<Order> getOrderRepository() {
		return orderRepository;
	}

}

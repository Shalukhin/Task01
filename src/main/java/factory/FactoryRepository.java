package factory;

import entity.Client;
import entity.Order;
import entity.tour.Tour;
import repository.EntityRepository;
//import repository.Repository;
//import repository.impl.ClientRepository;
//import repository.impl.OrderRepository;
//import repository.impl.TourRepository;

public class FactoryRepository {
	
	private final static FactoryRepository instance = new FactoryRepository();
	
//	private final Repository<Tour> tourRepository = new TourRepository();	
//	private final Repository<Client> clientRepository = new ClientRepository();
//	private final Repository<Order> orderRepository = new OrderRepository();
	
	private final EntityRepository<Tour> tourRepository = new EntityRepository<Tour>();	
	private final EntityRepository<Client> clientRepository = new EntityRepository<Client>();
	private final EntityRepository<Order> orderRepository = new EntityRepository<Order>();	
	
	private FactoryRepository() {};
	
	public static FactoryRepository getInstance() {
		return instance;
	}
	
	public EntityRepository<Tour> getTourRepository() {
		return tourRepository;
	}
	
	public EntityRepository<Client> getClientRepository() {
		return clientRepository;
	}
	
	public EntityRepository<Order> getOrderRepository() {
		return orderRepository;
	}

}

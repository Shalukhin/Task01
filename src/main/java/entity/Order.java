package entity;

import java.util.Arrays;

public class Order {
	
	private Client client;
	private Tour[] tours;
	
	public Order() {
		super();		
	}
	
	public Order(Client client, Tour tour) {
		super();
		this.client = client;
		this.tours = new Tour[1];
		this.tours[0] = tour;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Tour[] getTours() {
		return tours;
	}

	public void setTours(Tour[] tours) {
		this.tours = tours;
	}
	
	public void setToursIndex(Tour tour, int index) {
		if (index >= tours.length) {
			tours = Arrays.copyOf(tours, tours.length + 1);
			tours[tours.length - 1] = tour;
			return;
		}
		tours[index] = tour;
	}

	@Override
	public String toString() {
		return "Order [client=" + client + ", tours=" + Arrays.toString(tours) + "]";
	}	
}

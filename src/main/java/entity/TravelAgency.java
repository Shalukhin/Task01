package entity;

import java.util.Arrays;

import com.epam.training.step04.task2_05.beans.tours.Tour;

public class TravelAgency {
	
	private String name = "название турагентства не задано";
	private Tour[] all_tours = new Tour[0];
	private Order[] all_orders = new Order[0];
	
	public TravelAgency() {
		super();		
	}
	
	public TravelAgency(String name) {
		super();
		this.name = name;		
	}

	public TravelAgency(String name, Tour[] all_tours, Order[] all_orders) {
		super();
		this.name = name;
		this.all_tours = all_tours;
		this.all_orders = all_orders;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Tour[] getAll_tours() {
		return all_tours;
	}

	public void setAll_tours(Tour[] all_tours) {
		this.all_tours = all_tours;
	}
	
	public void setAll_toursIndex(Tour tour, int index) {
		
		if (index >= all_tours.length) {
			all_tours = Arrays.copyOf(all_tours, all_tours.length + 1);
			all_tours[all_tours.length - 1] = tour;
			return;
		}
		
		all_tours[index] = tour;
	}

	public Order[] getAll_orders() {
		return all_orders;
	}

	public void setAll_orders(Order[] all_orders) {
		this.all_orders = all_orders;
	}
	
	public void setAll_ordersIndex(Order order, int index) {
		
		if (index >= all_orders.length) {
			all_orders = Arrays.copyOf(all_orders, all_orders.length + 1);
			all_orders[all_orders.length - 1] = order;
			return;
		}
		
		all_orders[index] = order;
	}

	@Override
	public String toString() {
		return "TravelAgency: name = \"" + name + "\":\n  all_tours=" + Arrays.toString(all_tours) + "\n  all_orders="
				+ Arrays.toString(all_orders);
	}

}

package repository.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import entity.Order;
import repository.Repository;
import util.Specification;
import util.Validator;
import util.exception.RepositoryException;

public class OrderRepository implements Repository<Order> {
	
	private Set<Order> orders;
	
	

	public OrderRepository() {
		super();
		orders = new HashSet<Order>();
	}

	@Override
	public boolean save(Order order) throws RepositoryException {
		if (Validator.isNullValue(order)) {
			throw new RepositoryException("add_null_order");
		}
		return orders.add(order);
	}

	@Override
	public Collection<Order> find(Specification<Order> specification) throws RepositoryException {
		if (Validator.isNullValue(specification)) {
			throw new RepositoryException("find_null_specification_order");
		}
		Set<Order> result = new HashSet<Order>();
		for (Order existOrder : orders) {
			if (specification.specified(existOrder)) {
				result.add(existOrder);
			}
		}
		if (result.size() == 0) {
			throw new RepositoryException("orders_not_found");
		}
		return result;
	}

	@Override
	public Collection<Order> getAll() {
		return orders;
	}

	@Override
	public boolean delete(Order order) throws RepositoryException {
		if (Validator.isNullValue(order)) {
			throw new RepositoryException("delete_null_order");
		}
		return orders.remove(order);
	}

	@Override
	public boolean update(Order orderUpdate) throws RepositoryException {
		if (Validator.isNullValue(orderUpdate)) {
			throw new RepositoryException("update_null_order");
		}
		Order deleteOrder = (Order) find(new Specification<Order>() {			
			@Override
			public boolean specified(Order order) {
				if (order.getId() == orderUpdate.getId()) {
					return true;
				}
				return false;
			}
		}).toArray()[0];
		
		if(delete(deleteOrder)) {
			return save(orderUpdate);
		} else {
			return false;
		}		
	}

}

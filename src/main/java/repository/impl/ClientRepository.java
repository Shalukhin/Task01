package repository.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import entity.Client;
import entity.tour.Tour;
import repository.Repository;
import util.Specification;
import util.Validator;
import util.exception.RepositoryException;

public class ClientRepository implements Repository<Client> {
	
	private Set<Client> clients;

	public boolean save(Client client) throws RepositoryException {
		if (Validator.isNullValue(client)) {
			throw new RepositoryException("add_null_client_to_repository");
		}

		return clients.add(client);
	}

	public Collection<Client> find(Specification<Client> specification) {
		
		Set<Client> result = new HashSet<Client>();
		for (Client existClient : clients) {
			if (specification.specified(existClient)) {
				result.add(existClient);
			}
		}
		return result;
	}

	public Collection<Client> getAll() {
		
		return clients;
	}

	public boolean delete(Client client) {
		
		return clients.remove(client);
	}

}

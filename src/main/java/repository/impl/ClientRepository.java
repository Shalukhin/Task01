package repository.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import entity.Client;
import repository.Repository;
import util.Specification;
import util.Validator;
import util.exception.RepositoryException;

public class ClientRepository implements Repository<Client> {
	
	private Set<Client> clients;

	public ClientRepository() {
		super();
		clients = new HashSet<Client>();
	}

	public boolean save(Client client) throws RepositoryException {
		if (Validator.isNullValue(client)) {
			throw new RepositoryException("add_null_client");
		}

		return clients.add(client);
	}

	public Collection<Client> find(Specification<Client> specification) throws RepositoryException {
		
		if (Validator.isNullValue(specification)) {
			throw new RepositoryException("find_null_specification_client");
		}
		
		Set<Client> result = new HashSet<Client>();
		for (Client existClient : clients) {
			if (specification.specified(existClient)) {
				result.add(existClient);
			}
		}
		if (result.size() == 0) {
			throw new RepositoryException("clients_not_found");
		}
		return result;
	}

	public Collection<Client> getAll() {
		
		return clients;
	}

	public boolean delete(Client client) throws RepositoryException {
		if (Validator.isNullValue(client)) {
			throw new RepositoryException("delete_null_client");
		}
		return clients.remove(client);
	}
	
	public boolean update(final Client clientUpdate) throws RepositoryException {
		if (Validator.isNullValue(clientUpdate)) {
			throw new RepositoryException("update_null_tour");
		}
		Client deleteClient = (Client) find(new Specification<Client>() {			
			
			public boolean specified(Client client) {
				if (client.getId() == clientUpdate.getId()) {
					return true;
				}
				return false;
			}
		}).toArray()[0];
		
		if(delete(deleteClient)) {
			return save(clientUpdate);
		} else {
			return false;
		}		
	}

}

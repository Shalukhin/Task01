package repository;

import java.util.Collection;

import util.Specification;
import util.exception.RepositoryException;

public interface Repository <T> {

	boolean save(T obj) throws RepositoryException;
	
	default Collection<T> find(Specification<T> specification){
		
	};
	Collection<T> getAll();
	boolean delete(T obj);
	
	
}

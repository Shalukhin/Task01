package repository;

import java.util.Collection;

import exception.RepositoryException;
import specification.Specification;

public interface Repository <T> {

	boolean save(T obj);	
	Collection<T> find(Specification<T> specification);
	boolean delete(T obj) throws RepositoryException;	
	boolean update(T obj) throws RepositoryException;
	
	
}

package repository;

import java.util.Collection;

import util.Specification;
import util.exception.RepositoryException;

public interface Repository <T> {

	boolean save(T obj) throws RepositoryException;	
	Collection<T> find(Specification<T> specification) throws RepositoryException;
	boolean delete(T obj) throws RepositoryException;	
	boolean update(T obj) throws RepositoryException;
	
	
}

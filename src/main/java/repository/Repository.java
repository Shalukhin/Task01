package repository;

import java.util.Collection;

import exception.RepositoryException;
import util.Specification;

public interface Repository <T> {

	boolean save(T obj) throws RepositoryException;	
	Collection<T> find(Specification<T> specification) throws RepositoryException;
	boolean delete(T obj) throws RepositoryException;	
	boolean update(T obj) throws RepositoryException;
	
	
}

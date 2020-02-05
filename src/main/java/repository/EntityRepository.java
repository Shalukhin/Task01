package repository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import entity.Entity;
import util.Specification;
import util.Validator;
import util.exception.RepositoryException;

public class EntityRepository<T extends Entity> {
	
	private Set<T> collection;
	
	public EntityRepository() {
		super();
		collection = new HashSet<T>();
	}
	
	public boolean save(T obj) throws RepositoryException {
		if (Validator.isNullValue(obj)) {
			throw new RepositoryException("add_null");
		}
		return collection.add(obj);
	}
	
	public Collection<T> find(Specification<T> specification) throws RepositoryException {
		if (Validator.isNullValue(specification)) {
			throw new RepositoryException("find_null_specification");
		}
		Set<T> result = new HashSet<T>();
		for (T existObj : collection) {
			if (specification.specified(existObj)) {
				result.add(existObj);
			}
		}
		if (result.size() == 0) {
			throw new RepositoryException("object_not_found");
		}
		return result;
	}
	
	public Collection<T> getAll() {
		
		return collection;
	}
	
	public boolean delete(T obj) throws RepositoryException {
		if (Validator.isNullValue(obj)) {
			throw new RepositoryException("delete_null");
		}
		return collection.remove(obj);
	}
	
	public boolean update(T objUpdate) throws RepositoryException {
		if (Validator.isNullValue(objUpdate)) {
			throw new RepositoryException("update_null");
		}
		
		T deleteObj = null;
		for (T obj : collection) {
			if (obj.getId() == objUpdate.getId()) {
				deleteObj = obj;
			}
		}		
		
		if(delete(deleteObj)) {
			return save(objUpdate);
		} else {
			return false;
		}		
	}
	
	

}

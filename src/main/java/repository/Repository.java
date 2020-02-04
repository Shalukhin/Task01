package repository;

import java.util.Collection;

public interface Repository <T> {

	boolean save(T obj);
	
	Collection<T> getAll();
	boolean delete(T obj);
	
	
}

package org.elis.dao;

import java.util.List;



public interface DaoGeneral<T> {
	
	void insert(T entity);
	void update(T entity);
	void delete(T entity);
	T selectById(long iD);
	List <T> selectAll();
	
	
}

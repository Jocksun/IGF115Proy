package sv.edu.ues.igf115.hibernate;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, ID extends Serializable> {
	
	T create() ;

	void saveOrUpdate(T entity);

	T get(ID id);

	void delete(ID id);

	List<T> findAll();
}
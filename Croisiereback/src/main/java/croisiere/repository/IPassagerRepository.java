package croisiere.repository;

import java.util.List;

public interface IPassagerRepository<T,K> {

	List<T> findAll();
	T findById(K id);
	T save(T o);
	void deleteById(K id);
	void delete(T o);
	
}

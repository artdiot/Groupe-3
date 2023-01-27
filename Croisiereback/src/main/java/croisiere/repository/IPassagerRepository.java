package croisiere.repository;

import java.util.List;

import croisiere.model.Passager;

public interface IPassagerRepository extends IRepository<Passager, Integer> {

	List<Passager> findAll();
	Passager findById(Integer id);
	Passager save(Passager p);
	void deleteById(Integer id);
	void delete(Passager p);
	
}

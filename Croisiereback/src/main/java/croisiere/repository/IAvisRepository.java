package croisiere.repository;

import java.util.List;

import croisiere.model.Avis;

public interface IAvisRepository extends IRepository<Avis, Integer> {

	List<Avis> findAll();
	Avis findById(Integer id);
	Avis save(Avis a);
	void deleteById(Integer id);
	void delete(Avis a); 

}

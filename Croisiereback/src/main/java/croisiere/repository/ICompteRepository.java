package croisiere.repository;

import java.util.List;

import croisiere.model.Admin;
import croisiere.model.Client;
import croisiere.model.Compte;
import croisiere.model.MembreEquipage;

public interface ICompteRepository extends IRepository<Compte,Integer> {

	List<Compte> findAll();
	Compte findById(Integer id);
	Compte save(Compte o);
	void deleteById(Integer id);
	void delete(Compte o);
	List<Admin> findAllAdmin();
	List<Client> findAllClient();
	List<MembreEquipage> findAllMembreEquipage();
	
}

package croisiere.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import croisiere.model.Client;
import croisiere.model.Utilisateur;

public interface ClientRepository extends JpaRepository<Client, Integer> {
	
	
	@Query("select c from Client c where c.nom = ?1")
	Optional<Client> findByNom(String nom);
}
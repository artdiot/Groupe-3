package croisiere.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import croisiere.model.Avis;

public interface AvisRepository extends JpaRepository<Avis, Integer> {

}

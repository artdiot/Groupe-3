package croisiere.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import croisiere.model.Voyage;

public interface VoyageRepository extends JpaRepository<Voyage, Integer> {


}
package croisiere.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import croisiere.model.Etape;

public interface EtapeRepository extends JpaRepository<Etape,Integer>{
	
}

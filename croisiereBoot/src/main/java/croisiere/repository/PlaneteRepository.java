package croisiere.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import croisiere.model.Planete;

public interface PlaneteRepository extends JpaRepository<Planete,Integer>{

}

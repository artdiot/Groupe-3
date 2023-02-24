package croisiere.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import croisiere.model.Passager;

public interface PassagerRepository extends JpaRepository<Passager, Integer> {


}
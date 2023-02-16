package croisiere.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import croisiere.model.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {


}
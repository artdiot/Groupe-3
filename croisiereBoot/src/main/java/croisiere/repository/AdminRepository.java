package croisiere.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import croisiere.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{

}

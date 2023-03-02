package croisiere.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import croisiere.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation,Integer>{

	@Query("select r from Reservation r where r.client.id = ?1")
	List<Reservation> findAllByIdClient(Integer id);

}

package croisiere.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import croisiere.model.Passager;
import croisiere.model.Reservation;

public interface PassagerRepository extends JpaRepository<Passager, Integer> {

	@Query("select p from Passager p where p.reservation.id = ?1")
	List<Passager> findByReservationId(Integer id);


}
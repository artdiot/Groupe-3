package croisiere.repository;

import croisiere.model.Reservation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Integer>{

//	List<Reservation> findByClient();

}

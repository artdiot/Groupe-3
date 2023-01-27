package croisiere.repository;

import java.util.List;

import croisiere.model.Reservation;

public interface IReservationRepository extends IRepository<Reservation, Integer> {

	List<Reservation> findAll();
	Reservation findById(Integer id);
	Reservation save(Reservation r);
	void deleteById(Integer id);
	void delete(Reservation r); 
}

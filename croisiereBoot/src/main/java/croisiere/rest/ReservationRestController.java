package croisiere.rest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import croisiere.model.Client;
import croisiere.model.Passager;
import croisiere.model.Reservation;
import croisiere.model.Views;
import croisiere.repository.ClientRepository;
import croisiere.repository.PassagerRepository;
import croisiere.repository.ReservationRepository;

@RestController
@RequestMapping("/reservation")
@CrossOrigin("*")
public class ReservationRestController {
	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private ClientRepository clientRepo;
	@Autowired
	private PassagerRepository passagerRepo;


	@GetMapping("")
	@JsonView(Views.ViewReservation.class)
	public List<Reservation> findAll() {
		List<Reservation> reservations = reservationRepository.findAll();

		return reservations;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewReservation.class)
	public Reservation findById(@PathVariable Integer id) {
		Optional<Reservation> optReservation = reservationRepository.findById(id);

		if (optReservation.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optReservation.get();
	}
	
//	@GetMapping("/client/{id}")
//	@JsonView(Views.ViewReservation.class)
//	public List<Reservation> findAllByClient(@PathVariable Integer id) {
//		List<Reservation> reservations = reservationRepository.findAllByClient();
//		
//		
//		return reservations;
//	}


	@PostMapping("")
	@JsonView(Views.ViewReservation.class)
	public Reservation create(@RequestBody Reservation reservation) {
		reservation = reservationRepository.save(reservation);

		return reservation;
	}
	
	@PostMapping("/form/")
	@JsonView(Views.ViewReservation.class)
	public Reservation createForm(@RequestBody Reservation reservation) {
		reservation = reservationRepository.save(reservation);

		Client client = clientRepo.save(reservation.getClient());
		for(Passager p : reservation.getPassagers()) {
			p.setReservation(reservation);
			passagerRepo.save(p);
		}
		LocalDate dateDepart = reservation.getVoyage().calculDateDepart();
		reservation.setDate(dateDepart);
		
		reservation.setPrix(reservation.calculPrix());
		reservation = reservationRepository.save(reservation);
		return reservation;
	}
	
	
	@PutMapping("/{id}")
	@JsonView(Views.ViewReservation.class)
	public Reservation update(@RequestBody Reservation reservation, @PathVariable Integer id) {
		if (id != reservation.getId()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		if (!reservationRepository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		reservation = reservationRepository.save(reservation);

		return reservation;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		List<Passager> passagers = passagerRepo.findByReservationId(id);
		for(Passager p : passagers) {
			p.setReservation(null);
			passagerRepo.save(p);
		}
		reservationRepository.deleteById(id);
	}
	

}

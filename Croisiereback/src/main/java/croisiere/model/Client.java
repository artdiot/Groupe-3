package croisiere.model;

import java.util.List;

public class Client extends Compte {
	private List<Reservation> reservations;
	
	public Client() {
		super();
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	
}

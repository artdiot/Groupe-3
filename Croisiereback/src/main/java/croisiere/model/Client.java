package croisiere.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;
@Entity
@DiscriminatorValue("customer")
public class Client extends Compte {
	@Transient
	private List<Reservation> reservations=new ArrayList<>();
	
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

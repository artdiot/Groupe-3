package croisiere.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
@Entity
@DiscriminatorValue("customer")
public class Client extends Compte {
	@OneToMany(mappedBy ="client")
	private List<Reservation> reservations=new ArrayList<>();
	@OneToMany(mappedBy="client")
	private List<Avis> listeAvis=new ArrayList<>();
	
	public Client() {
		super();
	}

	
	public Client(String login, String password, String nom, String prenom, String email, Adresse adresse) {
		super(login, password, nom, prenom, email, adresse);
	}


	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public List<Avis> getListeAvis() {
		return listeAvis;
	}

	public void setListeAvis(List<Avis> listeAvis) {
		this.listeAvis = listeAvis;
	}
	
	
}

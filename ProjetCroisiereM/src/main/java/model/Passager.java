package model;

public class Passager {
	private String nom;
	private String prenom;
	private Reservation reservation;
	
	
	public Passager(String nom, String prenom, Reservation reservation) {
		this.nom = nom;
		this.prenom = prenom;
		this.reservation = reservation;
	}
	
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	@Override
	public String toString() {
		return "Passager [nom=" + nom + ", prenom=" + prenom + ", reservation=" + reservation + "]";
	}
}

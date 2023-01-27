package croisiere.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "travel")
public class Voyage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "price")
	private double prix;
	@Column(name = "distance")
	private double distance;
	@Column(name = "duration")
	private int duree;
	@Column(name = "capacity")
	private int capacite;

	@OneToMany(mappedBy = "voyage")
	private List<Etape> etapes = new ArrayList<>();
	@OneToMany(mappedBy = "voyage")
	private List<Reservation> reservations = new ArrayList<>();
	@OneToMany(mappedBy = "voyage")
	private List<Avis> avis = new ArrayList<>();
	
	@OneToMany(mappedBy = "voyage")
	private List<EquipageVoyage> equipageVoyage = new ArrayList<>();	
	
	
	
	
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public double getPrix() {
	return prix;
}
public void setPrix(double prix) {
	this.prix = prix;
}
public double getDistance() {
	return distance;
}
public void setDistance(double distance) {
	this.distance = distance;
}
public int getDuree() {
	return duree;
}
public void setDuree(int duree) {
	this.duree = duree;
}
public int getCapacite() {
	return capacite;
}
public void setCapacite(int capacite) {
	this.capacite = capacite;
}
public List<Etape> getEtapes() {
	return etapes;
}
public void setEtapes(List<Etape> etapes) {
	this.etapes = etapes;
}
public List<Reservation> getReservations() {
	return reservations;
}
public void setReservations(List<Reservation> reservations) {
	this.reservations = reservations;
}
public Voyage() {
	super();
}





}

package croisiere.model;
import java.util.ArrayList;
import java.util.List;

public class Voyage {
private Integer id;
private double prix;
private double distance;
private int duree;
private int capacite;


private List<Etape> etapes = new ArrayList<>();
private List<Reservation> reservations = new ArrayList<>();
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

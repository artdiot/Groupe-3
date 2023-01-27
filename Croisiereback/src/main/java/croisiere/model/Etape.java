package croisiere.model;

import java.time.LocalDate;

public class Etape {

	private Integer id;
	private LocalDate depart;
	private LocalDate arrivee;
	
	private Planete planetDepart;
	private Planete planetArrivé;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getDepart() {
		return depart;
	}
	public void setDepart(LocalDate depart) {
		this.depart = depart;
	}
	public LocalDate getArrivee() {
		return arrivee;
	}
	public void setArrivee(LocalDate arrivee) {
		this.arrivee = arrivee;
	}
	public Planete getPlanetDepart() {
		return planetDepart;
	}
	public void setPlanetDepart(Planete planetDepart) {
		this.planetDepart = planetDepart;
	}
	public Planete getPlanetArrivé() {
		return planetArrivé;
	}
	public void setPlanetArrivé(Planete planetArrivé) {
		this.planetArrivé = planetArrivé;
	}
	public Etape() {
		super();
	}
	
	
	
}

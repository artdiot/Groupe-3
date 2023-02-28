package croisiere.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "stage")
public class Etape {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ViewBase.class)
	private Integer id;
	@Version
	@Column
	private Integer version;
	@Column(name = "departure")
	@JsonView(Views.ViewBase.class)
	private LocalDate depart;
	@Column(name = "arrival")
	@JsonView(Views.ViewBase.class)
	private LocalDate arrivee;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "planet_departure_id")
	@JsonView(Views.ViewBase.class)
	private Planete planeteDepart;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "planet_arrival_id")
	@JsonView(Views.ViewBase.class)
	private Planete planeteArrivee;
	
	@ManyToOne
	@JoinColumn(name = "travel_id")
	@JsonView(Views.ViewEtape.class)
	private Voyage voyage;
	
	private double vitesse = 10;
	
	public Etape() {
		super();
	}
	
	public Etape(LocalDate depart, LocalDate arrivee, Planete planeteDepart,
			Planete planeteArrivee, Voyage voyage) {
		super();
		this.depart = depart;
		this.arrivee = arrivee;
		this.planeteDepart = planeteDepart;
		this.planeteArrivee = planeteArrivee;
		this.voyage = voyage;
	}
	
	public Etape( LocalDate depart, Planete planeteDepart, Planete planeteArrivee) {
		this.depart = depart;
		this.planeteDepart = planeteDepart;
		this.planeteArrivee = planeteArrivee;
		this.arrivee= tempstrajet();
	}

	public LocalDate tempstrajet() {
		
		double temps= planeteDepart.calculDistance(planeteArrivee)/vitesse; //calcul temps du voyage
		
		arrivee=depart.plusDays(Math.round(temps)); // ajout du temps du voyage
	
		return arrivee;
	}

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
		return planeteDepart;
	}
	public void setPlanetDepart(Planete planetDepart) {
		this.planeteDepart = planetDepart;
	}
	public Planete getPlanetArrivee() {
		return planeteArrivee;
	}
	public void setPlanetArrivee(Planete planetArrivee) {
		this.planeteArrivee = planetArrivee;
	}

	
	
	
}

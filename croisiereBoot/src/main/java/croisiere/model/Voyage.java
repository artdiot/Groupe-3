package croisiere.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Fetch;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "travel")
public class Voyage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ViewBase.class)
	private Integer id;
	@Version
	@JsonView(Views.ViewBase.class)
	private int version;
	@Column(name = "price")
	@JsonView(Views.ViewBase.class)
	private double prix;
	@Column(name = "distance")
	@JsonView(Views.ViewBase.class)
	private double distance;
	@Column(name = "duration")
	@JsonView(Views.ViewBase.class)
	private int duree;
	@Column(name = "capacity")
	@JsonView(Views.ViewBase.class)
	private int capacite;

	@OneToMany(fetch = FetchType.EAGER,mappedBy = "voyage")
	@JsonView(Views.ViewVoyage.class)
	private List<Etape> etapes = new ArrayList<>();
	
	@OneToMany(mappedBy = "voyage")
	@JsonView(Views.ViewVoyage.class)
	private List<Reservation> reservations = new ArrayList<>();
	@OneToMany(mappedBy = "voyage")
	@JsonView(Views.ViewVoyage.class)
	private List<Avis> avis = new ArrayList<>();

	@OneToMany(mappedBy = "voyage")
	@JsonView(Views.ViewVoyage.class)
	private List<EquipageVoyage> equipageVoyage = new ArrayList<>();

	public Voyage() {
		super();
	}
	
	public Voyage(double prix, double distance, int duree, int capacite) {
		super();
		this.prix = prix;
		this.distance = distance;
		this.duree = duree;
		this.capacite = capacite;
		
	}
	
	public Voyage (int capacite, List<Etape> etapes) {
		this.capacite = capacite;
		this.etapes = etapes;
		this.distance= calculDistance();
		this.duree=calculDuree();
		this.prix=calculPrix();
	}
	
	public Voyage(double prix, double distance, int duree, int capacite, List<Etape> etapes) {
		super();
		this.prix = prix;
		this.distance = distance;
		this.duree = duree;
		this.capacite = capacite;
		this.etapes = etapes;
	}
	
	public double calculDistance() {
	
		distance = 0; 
		
		for(Etape etape: etapes) {
			 distance = distance + etape.getPlanetDepart().calculDistance(etape.getPlanetArrivee());
			 System.out.println("Apres l'Etape, la distance est maintenant de "+ distance);
		}
		
		 System.out.println("La distance du Voyage, la distance est maintenant de "+ distance);
		 
		 
		 return distance;
	}
	public LocalDate calculDateDepart() {
		
		LocalDate depart = etapes.get(0).getDepart();
		
		for(Etape etape: etapes) {
			
			if (etape.getDepart().isBefore(depart)) {
			depart = etape.getDepart();
			}
		}
		return depart;
	}
	
public LocalDate calculDateArrivee() {
		
		LocalDate arrivee = etapes.get(0).getArrivee();
		
		for(Etape etape: etapes) {
			
			if (etape.getArrivee().isAfter(arrivee)) {
			arrivee = etape.getDepart();
			}
		}
		return arrivee;
	}
	
	public int calculDuree() {
		
		
		LocalDate depart = etapes.get(0).getDepart();
		LocalDate arrivee = etapes.get(0).getArrivee();
		
		for(Etape etape: etapes) {
			
			if (etape.getDepart().isBefore(depart)) {
			depart = etape.getDepart();
			} 
			
			if (etape.getArrivee().isAfter(arrivee)) {
			arrivee = etape.getArrivee();
			}
	}
		duree = (int) (ChronoUnit.DAYS.between(depart, arrivee)+1);
		
		return duree;
	}
	
	public Planete calculPlaneteDepart() {
		Planete planeteDepart = etapes.get(0).getPlanetDepart();
		System.out.println("test1");
		int min = etapes.get(0).getId();
		System.out.println("test2");
		for(Etape etape: etapes) {
			
			if (etape.getId()< min) {
			min = etape.getId();	
			planeteDepart=etape.getPlanetDepart();
			} 
		}
		return planeteDepart;
	}
	
	public Planete calculPlaneteArrivee() {
		Planete planeteArrivee = etapes.get(0).getPlanetArrivee();
		int max = etapes.get(0).getId();
		
		for(Etape etape: etapes) {
			
			if (etape.getId()>max) {
			max = etape.getId();	
			planeteArrivee=etape.getPlanetDepart();
			} 
		}
		return planeteArrivee;
	}
	
	public double calculPrix() {
		double prix = duree * 20;
		System.out.println("le prix est de " + prix + " dollars spaciaux");
		return prix;
	}
	
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

}

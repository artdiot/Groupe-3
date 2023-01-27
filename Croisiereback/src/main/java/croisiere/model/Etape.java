package croisiere.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "stage")
public class Etape {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "departure")
	private LocalDate depart;
	@Column(name = "arrival")
	private LocalDate arrivee;
	@Transient
	//@Column(name = "planetdeparture")
	private Planete planeteDepart;
	@Transient
	//@Column(name = "planetarrival")
	private Planete planeteArrive;
	
	
	
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
	public Planete getPlanetArrivé() {
		return planeteArrive;
	}
	public void setPlanetArrivé(Planete planetArrivé) {
		this.planeteArrive = planetArrivé;
	}
	public Etape() {
		super();
	}
	
	
	
}

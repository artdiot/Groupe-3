package croisiere.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="booking")
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ViewBase.class)
	private Integer id;
	@Version
	@JsonView(Views.ViewBase.class)
	private int version;
	@Column(name = "price", length = 10)
	@JsonView(Views.ViewBase.class)	
	private double prix;
	@Column(name="departure_date", length = 10)
	@JsonView(Views.ViewBase.class)
	private LocalDate date;
	@Column(name="class")
	@JsonView(Views.ViewBase.class)
	private int classe;
	@OneToMany(mappedBy ="reservation")
	@JsonView(Views.ViewReservation.class)
	private List<Passager> passagers = new ArrayList<>();
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	@JsonView(Views.ViewReservationInfo.class)
	private Client client;
	@ManyToOne
	@JoinColumn(name = "travel_id")
	@JsonView(Views.ViewReservationInfo.class)
	private Voyage voyage;
	
	public Reservation() {
		super();
	}
	
	

	public Reservation( double prix, LocalDate date, int classe) {
		
		this.prix = prix;
		this.date = date;
		this.classe = classe;

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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getClasse() {
		return classe;
	}

	public void setClasse(int classe) {
		this.classe = classe;
	}

	public List<Passager> getPassagers() {
		return passagers;
	}

	public void setPassagers(List<Passager> passagers) {
		this.passagers = passagers;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Voyage getVoyage() {
		return voyage;
	}

	public void setVoyage(Voyage voyage) {
		this.voyage = voyage;
	}
	
	
	
	
}

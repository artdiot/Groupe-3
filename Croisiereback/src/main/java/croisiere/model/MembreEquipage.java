package croisiere.model;


import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@DiscriminatorValue("crew")
public class MembreEquipage extends Compte{
	@Column(name="salary")
	private double salaire;
	@Column(name="job")
	private Metier metier;
	@Column(name="clearance")
	private int niveauAcces;
	@Column(name="available")
	private boolean disponible;
	private int experience;
	@Transient
	private EquipageVoyage equipage;
	
	public MembreEquipage() {
	super();
	}
	
	

	public MembreEquipage(String login, String password, String nom, String prenom, 
			String email, Adresse adresse, double salaire, Metier metier, int niveauAcces,
			boolean disponible, int experience) {
		super(login, password, nom, prenom, email, adresse);
		this.salaire = salaire;
		this.metier = metier;
		this.niveauAcces = niveauAcces;
		this.disponible=disponible;
		this.experience=experience;
	}



	public double getSalaire() {
		return salaire;
	}

	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}

	public Metier getMetier() {
		return metier;
	}

	public void setMetier(Metier metier) {
		this.metier = metier;
	}

	public int getNiveauAcces() {
		return niveauAcces;
	}

	public void setNiveauAcces(int niveauAcces) {
		this.niveauAcces = niveauAcces;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public EquipageVoyage getEquipage() {
		return equipage;
	}

	public void setEquipage(EquipageVoyage equipage) {
		this.equipage = equipage;
	}
	
	
	
}

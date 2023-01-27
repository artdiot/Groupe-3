package croisiere.model;

public class MembreEquipage {
	private double salaire;
	private Metier metier;
	private int niveauAcces ;
	private boolean disponible;
	private int experience;
	private Equipage equipage;
	
	public MembreEquipage() {
	super();
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

	public Equipage getEquipage() {
		return equipage;
	}

	public void setEquipage(Equipage equipage) {
		this.equipage = equipage;
	}
	
	
	
}

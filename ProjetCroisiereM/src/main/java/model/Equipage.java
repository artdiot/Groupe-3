package model;

public class Equipage extends Compte {
	
	private Double salaire;
	private Metier metier;
	
	
	
	public Equipage(String login, String password, String nom, String prenom, Double salaire, Metier metier) {
		super(login, password, nom, prenom);
		this.salaire = salaire;
		this.metier = metier;
	}
	public Double getSalaire() {
		return salaire;
	}
	public void setSalaire(Double salaire) {
		this.salaire = salaire;
	}
	public Metier getMetier() {
		return metier;
	}
	public void setMetier(Metier metier) {
		this.metier = metier;
	}

	@Override
	public String toString() {
		return "Equipage [salaire=" + salaire + ", metier=" + metier + ", login="
				+ login + ", password=" + password + ", nom=" + nom + ", prenom=" + prenom + "]";
	} 
	
	
	
}

package model;

public abstract class Compte {

	protected String login;
	protected String password;
	protected String nom;
	protected String prenom;
	
	
	public Compte(String login, String password, String nom, String prenom) {
		super();
		this.login = login;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Override
	public String toString() {
		return "Compte [login=" + login + ", password=" + password + ", nom=" + nom + ", prenom=" + prenom + "]";
	}
	
	
}

package croisiere.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "users")
public class Utilisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ViewBase.class)
	private Integer id;
	@Column(name = "login", length = 100, nullable = false, unique = true)
	@JsonView(Views.ViewBase.class)
	private String identifiant;
	@Column(name = "password", length = 255)
	@JsonView(Views.ViewBase.class)
	private String motDePasse;
	@Column(name = "last_name", length = 100)
	@JsonView(Views.ViewBase.class)
	private String nom;
	@Column(name = "first_name", length = 100)
	@JsonView(Views.ViewBase.class)
	private String prenom;
	@Column(name = "role", nullable = false)
	@Enumerated(EnumType.STRING)
	@JsonView(Views.ViewUtilisateur.class)
	private Role role;

	@OneToOne(mappedBy = "utilisateur")
	private Compte compte;

	public Utilisateur() {
		super();
	}

	public Utilisateur(String identifiant, String motDePasse, String nom, String prenom, Role role) {
		super();
		this.identifiant = identifiant;
		this.motDePasse = motDePasse;
		this.nom = nom;
		this.prenom = prenom;
		this.role=role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
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

	public Role getRoles() {
		return role;
	}

	public void setRoles(Role role) {
		this.role = role;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

}

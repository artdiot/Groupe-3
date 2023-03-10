package croisiere.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "planet")
public class Planete {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "name")
	private String nom;
	@Column(name = "positionX")
	private double positionX;
	@Column(name = "positionY")
	private double positionY;	
	@Column(name = "positionZ")
	private double positionZ;
	
	public Planete() {
		super();
	}	
	
	public Planete(String nom, double positionX, double positionY, double positionZ) {
		super();
		this.nom = nom;
		this.positionX = positionX;
		this.positionY = positionY;
		this.positionZ = positionZ;
	}




	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getPositionX() {
		return positionX;
	}
	public void setPositionX(double positionX) {
		this.positionX = positionX;
	}
	public double getPositionY() {
		return positionY;
	}
	public void setPositionY(double positionY) {
		this.positionY = positionY;
	}
	public double getPositionZ() {
		return positionZ;
	}
	public void setPositionZ(double positionZ) {
		this.positionZ = positionZ;
	}

	
	
		
	
	
	
	
}

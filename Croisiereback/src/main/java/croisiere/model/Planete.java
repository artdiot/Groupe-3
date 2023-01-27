package croisiere.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "travel")
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
	public Planete() {
		super();
	}	
	
	
		
	
	
	
	
}

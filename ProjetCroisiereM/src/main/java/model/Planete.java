package model;

import java.util.Arrays;

public class Planete {
	
	private Integer id;
	private String nom;
	private double[] position;
	
	public Planete(Integer id, String nom, double[] position) {
		super();
		this.id = id;
		this.nom = nom;
		this.position = position;
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

	public double[] getPosition() {
		return position;
	}

	public void setPosition(double[] position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Planete [id=" + id + ", nom=" + nom + ", position=" + Arrays.toString(position) + "]";
	}

}

package model;

import java.util.List;

public class Voyage {

	private List<Equipage> listequipages;
	private Planete departP;
	private Planete arriveeP;
	private double prix;
	

	public Voyage(List<Equipage> listequipages, Planete departP, Planete arriveeP) {
		super();
		this.listequipages = listequipages;
		this.departP = departP;
		this.arriveeP = arriveeP;
	}
	public List<Equipage> getListequipages() {
		return listequipages;
	}
	public void setListequipages(List<Equipage> listequipages) {
		this.listequipages = listequipages;
	}
	public Planete getDepartP() {
		return departP;
	}
	public void setDepartP(Planete departP) {
		this.departP = departP;
	}
	public Planete getArriveeP() {
		return arriveeP;
	}
	public void setArriveeP(Planete arriveeP) {
		this.arriveeP = arriveeP;
	}
	
	public double getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	
	@Override
	public String toString() {
		return "Voyage [listequipages=" + listequipages + ", departP=" + departP + ", arriveeP=" + arriveeP + "]";
	}

}

package model;

public class Etape {
	Planete planete;
	Voyage voyage;
	
	
	public Etape(Planete planete, Voyage voyage) {
		super();
		this.planete = planete;
		this.voyage = voyage;
	}
	
	public Planete getPlanete() {
		return planete;
	}
	public void setPlanete(Planete planete) {
		this.planete = planete;
	}
	public Voyage getVoyage() {
		return voyage;
	}
	public void setVoyage(Voyage voyage) {
		this.voyage = voyage;
	}
	@Override
	public String toString() {
		return "Etape [planete=" + planete + ", voyage=" + voyage + "]";
	}
	
}

package croisiere.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class Adresse {
	@Column(name="planete")
	private String planete;
	@Column(name="district")
	private String district;
	@Column(name="city")
	private String ville;
	@Column(name="street")
	private String rue;
	
	public Adresse() {
		super();
	}
	
	public String getPlanete() {
		return planete;
	}
	public void setPlanete(String planete) {
		this.planete = planete;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	
}

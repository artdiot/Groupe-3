package croisiere.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name= "review")
public class Avis {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ViewBase.class)
	private Integer id;
	@Column(name="score", length = 5)
	@JsonView(Views.ViewBase.class)
	private int note;
	@Column(name="comment", length = 255)
	@JsonView(Views.ViewBase.class)
	private String commentaire;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="customer_id")
	@JsonView(Views.ViewAvis.class)
	private Client client;
	@ManyToOne
	@JoinColumn(name = "travel_id")
	@JsonView(Views.ViewAvis.class)
	private Voyage voyage;
	
	

	public Avis() {
		super();
	}
	
	
	public Avis(int note, String commentaire) {
		super();
		this.note = note;
		this.commentaire = commentaire;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getNote() {
		return note;
	}
	public void setNote(int note) {
		this.note = note;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Voyage getVoyage() {
		return voyage;
	}
	public void setVoyage(Voyage voyage) {
		this.voyage = voyage;
	}
	
	
}

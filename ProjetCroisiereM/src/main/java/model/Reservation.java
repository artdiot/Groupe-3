package model;

public class Reservation {
	private Voyage voyage;
	private Planete planete;
	private Client client;
	private double prix;
	
	
	
	public Reservation(Voyage voyage, Client client, int nbPassager) {
		super();
		this.voyage = voyage;
		this.client = client;
		this.prix = nbPassager * voyage.getPrix();
	}
	
	public Voyage getVoyage() {
		return voyage;
	}
	public void setVoyage(Voyage voyage) {
		this.voyage = voyage;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	public double getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}
	
	@Override
	public String toString() {
		return "Reservation [voyage=" + voyage + ", client=" + client + ", prix=" + prix + "]";
	}
	
	
	
	
}

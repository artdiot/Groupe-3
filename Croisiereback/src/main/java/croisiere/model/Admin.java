package croisiere.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("admin")
public class Admin extends Compte {
	public Admin() {
		super();
	}

	public Admin(String login, String password, String nom, String prenom, String email, Adresse adresse) {
		super(login, password, nom, prenom, email, adresse);
	}

}
	
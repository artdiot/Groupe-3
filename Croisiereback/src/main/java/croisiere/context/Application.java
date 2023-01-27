package croisiere.context;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import quest.repository.IClientRepository;
import quest.repository.jpa.ClientRepositoryJpa;


public class Application {
	private static Application instance = null;

	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("croisiere");

	private Application() {
	}

	public static Application getInstance() {
		if (instance == null) {
			instance = new Application();
		}

		return instance;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}
	
	
}

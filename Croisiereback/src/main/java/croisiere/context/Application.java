package croisiere.context;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import croisiere.repository.ICompteRepository;
import croisiere.repository.jpa.CompteRepositoryjpa;

public class Application {
	private static Application instance = null;

	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("croisiere");
	private final ICompteRepository compteRepo = new CompteRepositoryjpa();

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

	public ICompteRepository getCompteRepo() {
		return compteRepo;
	}

	public static void setInstance(Application instance) {
		Application.instance = instance;
	}
	
	
	
	
}

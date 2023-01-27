package croisiere.context;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import croisiere.repository.IAvisRepository;
import croisiere.repository.ICompteRepository;
import croisiere.repository.IPassagerRepository;
import croisiere.repository.IPlaneteRepository;
import croisiere.repository.IReservationRepository;
import croisiere.repository.IVoyageRepository;
import croisiere.repository.jpa.AvisRepositoryjpa;
import croisiere.repository.jpa.CompteRepositoryjpa;
import croisiere.repository.jpa.PassagerRepositoryjpa;
import croisiere.repository.jpa.PlaneteRepositoryjpa;
import croisiere.repository.jpa.ReservationRepositoryjpa;
import croisiere.repository.jpa.VoyageRepositoryjpa;

public class Application {
	private static Application instance = null;

	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("croisiere");
	private final ICompteRepository compteRepo = new CompteRepositoryjpa();
	private final IVoyageRepository voyageRepo = new VoyageRepositoryjpa();
	private final IPlaneteRepository planeteRepo = new PlaneteRepositoryjpa();
	private final IPassagerRepository passagerRepo = new PassagerRepositoryjpa();
	private final IAvisRepository avisRepo = new AvisRepositoryjpa();
	private final IReservationRepository reservationRepo = new ReservationRepositoryjpa();

	private Application() {
	}

	public static Application getInstance() {
		if (instance == null) {
			instance = new Application();
		}

		return instance;
	}



	public static void setInstance(Application instance) {
		Application.instance = instance;
	}
	
	public EntityManagerFactory getEmf() {
		return emf;
	}

	public ICompteRepository getCompteRepo() {
		return compteRepo;
	}


	public IVoyageRepository getVoyageRepo() {
		return voyageRepo;
	}

	public IPlaneteRepository getPlaneteRepo() {
		return planeteRepo;
	}

	public IPassagerRepository getPassagerRepo() {
		return passagerRepo;
	}

	public IAvisRepository getAvisRepo() {
		return avisRepo;
	}

	public IReservationRepository getReservationRepo() {
		return reservationRepo;
	}
	
	
	
	
}

package croisiere.context;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import croisiere.repository.ICompteRepository;
import croisiere.repository.IPlaneteRepository;
import croisiere.repository.IVoyageRepository;
import croisiere.repository.IAvisRepository;
import croisiere.repository.IPassagerRepository;
import croisiere.repository.IReservationRepository;

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

	public static void setInstance(Application instance) {
		Application.instance = instance;
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

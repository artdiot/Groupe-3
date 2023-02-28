package croisiereBoot;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import croisiere.CroisiereBootApplication;
import croisiere.model.Admin;
import croisiere.model.Adresse;
import croisiere.model.Client;
import croisiere.model.Etape;
import croisiere.model.Passager;
import croisiere.model.Planete;
import croisiere.model.Reservation;
import croisiere.model.Role;
import croisiere.model.Utilisateur;
import croisiere.model.Voyage;
import croisiere.repository.AdminRepository;
import croisiere.repository.AvisRepository;
import croisiere.repository.ClientRepository;
import croisiere.repository.EtapeRepository;
import croisiere.repository.PassagerRepository;
import croisiere.repository.PlaneteRepository;
import croisiere.repository.ReservationRepository;
import croisiere.repository.UtilisateurRepository;
import croisiere.repository.VoyageRepository;

@SpringBootTest(classes=CroisiereBootApplication.class)
class RemplissageTest {
	
	@Autowired
	private ClientRepository clientRepo;
	@Autowired
	private AvisRepository avisRepo;
	@Autowired
	private PlaneteRepository planeteRepo;
	@Autowired
	private EtapeRepository etapeRepo;

	@Autowired
	private VoyageRepository voyageRepo;
	@Autowired 
	private AdminRepository adminRepo;
	@Autowired
	private UtilisateurRepository utilisateurRepo;
	@Autowired
	private PassagerRepository passagerRepo;
	@Autowired
	private ReservationRepository reservationRepo;
	
	@Test
	public void RemplissageTest(){ // Penser à run en create (remettre en update avant de lancer l'application)

		Planete p1 = new Planete("TPT",4.0,3.0,0.0);
		planeteRepo.save(p1);
		Planete p2 = new Planete("Tatooine",0.0,1.0,3.14);
		planeteRepo.save(p2);
		Planete p3 = new Planete("Namek",15.7,2.3,6.9);
		planeteRepo.save(p3);
		Voyage v1 = new Voyage(150, 12.7, 2, 4);
		voyageRepo.save(v1);
		Etape e1 = new Etape(LocalDate.parse("2023-02-17"), LocalDate.parse("2023-02-19"), p1, p2, v1);
		etapeRepo.save(e1);
		Etape e2 = new Etape(LocalDate.parse("2023-02-19"), LocalDate.parse("2023-02-21"), p2, p3, v1);
		etapeRepo.save(e2);

		v1.getEtapes().add(e1);
		v1.getEtapes().add(e2);
		List<Etape> etapes1 = new ArrayList<Etape>();
		etapes1.add(e1);
		etapes1.add(e2);
		v1.setEtapes(etapes1);

		voyageRepo.save(v1);
		Voyage v2 = new Voyage(200, 12.8, 7, 12);
		voyageRepo.save(v2);
		Etape e3 = new Etape(LocalDate.parse("2023-04-17"), LocalDate.parse("2023-04-19"), p1, p2, v1);
		etapeRepo.save(e3);

		Etape e4 = new Etape(LocalDate.parse("2023-04-19"), LocalDate.parse("2023-04-21"), p2, p3, v1);
		etapeRepo.save(e4);

		List<Etape> etapes2 = new ArrayList<Etape>();
		etapes2.add(e3);
		etapes2.add(e4);
		v2.setEtapes(etapes2);
		voyageRepo.save(v2);

		Adresse a2= new Adresse("Terre", "district district", "Villeurbanne", "10 rue Abid");
		Client c2 = new Client("RIAN","Flo","f.lo@mail",a2);
		Adresse a1 = new Adresse("Mars","9","Marsville","10 rue de chez moi");
		Client c1 = new Client("DIOT", "Arthur", "a.d@mail",a1);
		clientRepo.save(c1);
		clientRepo.save(c2);
		Adresse a3 = new Adresse("LA planète","district de ouf","Superville","10 rue trop cool");
		Admin ad1 = new Admin("ISTRATEUR","Admin","ad.mini.stra@teur",a3);
		Utilisateur u1 = new Utilisateur("Arthur", "Diot", "Arthur", "Diot",Role.ADMIN,ad1);
		adminRepo.save(ad1);
		utilisateurRepo.save(u1);
		Utilisateur u2 = new Utilisateur("florian","123456","RIAN","Flo",Role.CLIENT,c2);
		utilisateurRepo.save(u2);
		
		
		Passager pas1 = new Passager("Robert--Ansart","Florian", LocalDate.parse("1993-05-03"));
		passagerRepo.save(pas1);
		Passager pas2 = new Passager("Diot","Arthur", LocalDate.parse("1996-05-03"));
		passagerRepo.save(pas2);
		Passager pas3 = new Passager("Salem","Rafiq",LocalDate.parse("1995-05-17"));
		passagerRepo.save(pas3);
		Reservation r1 = new Reservation(200.00, LocalDate.parse("2023-05-17"), 1);
		reservationRepo.save(r1);
		List<Passager> passagers1 = new ArrayList<Passager>();
		passagers1.add(pas1);
		r1.setPassagers(passagers1);
		r1.setVoyage(v1);
		r1.setClient(c2);
		reservationRepo.save(r1);
		pas1.setReservation(r1);
		passagerRepo.save(pas1);
		Reservation r2 = new Reservation(300, LocalDate.parse("2023-08-17"), 2);
		reservationRepo.save(r2);
		List<Passager> passagers2 = new ArrayList<Passager>();
		passagers2.add(pas2);

		r2.setPassagers(passagers2);
		r2.setVoyage(v2);
		r2.setClient(c2);
		reservationRepo.save(r2);
		pas2.setReservation(r2);
		passagerRepo.save(pas2);
		
		
	}
}

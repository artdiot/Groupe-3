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

		Planete p1 = new Planete("TPT",0.0,0.0,0.0);
		planeteRepo.save(p1);
		Planete p2 = new Planete("Le village d'Ewoks d'Endor",120.0,10.0,15);
		planeteRepo.save(p2);
		Planete p3 = new Planete("Gallifrey Gardens",45.7,2.3,6.9);
		planeteRepo.save(p3);
		Planete p4 = new Planete("Delorean Delta",15.7,2.3,6.9);
		planeteRepo.save(p4);
		Planete p5 = new Planete("L'Oasis d'Aldeeran",-35.2,-70.5,15.2);
		planeteRepo.save(p5);
		Planete p6 = new Planete("Mordor IV",50.2,48.6,-30.7);
		planeteRepo.save(p6);
		Planete p7 = new Planete("Soprastéroïde", -40.2,30.5,-62.7);
		planeteRepo.save(p7);
		Planete p8 = new Planete("Raxacoricofallapatorius",12.7,59.5,-40.2);
		planeteRepo.save(p8);
		
		Etape e1 = new Etape(LocalDate.parse("2023-02-17"), p1, p2);
		Etape e2 = new Etape(e1.getArrivee(), p2, p3);
		Etape e3 = new Etape(e2.getArrivee(), p3, p4);
		List<Etape> etapes1 = new ArrayList<Etape>();
		etapes1.add(e1);
		etapes1.add(e2);
		etapes1.add(e3);
		Voyage v1 = new Voyage(150,etapes1);
		v1=voyageRepo.save(v1);
		e1.setVoyage(v1);
		etapeRepo.save(e1);
		e2.setVoyage(v1);
		etapeRepo.save(e2);
		e3.setVoyage(v1);
		etapeRepo.save(e3);
		

		Etape e4 = new Etape(LocalDate.parse("2023-04-19"), p1, p6);
		Etape e5 = new Etape(e4.getDepart(),p6,p3);
		Etape e6 = new Etape(e5.getDepart(),p3,p8);
		List<Etape> etapes2 = new ArrayList<Etape>();
		etapes2.add(e4);
		etapes2.add(e5);
		etapes2.add(e6);
		Voyage v2 = new Voyage(200, etapes2);
		v2=voyageRepo.save(v2);
		e4.setVoyage(v2);
		etapeRepo.save(e4);
		e5.setVoyage(v2);
		etapeRepo.save(e5);
		e6.setVoyage(v2);
		etapeRepo.save(e6);

		Etape e7 = new Etape(LocalDate.parse("2023-05-07"),p4,p7);
		Etape e8 = new Etape(e7.getDepart(),p7,p5);
		List<Etape> etapes3 = new ArrayList<Etape>();
		etapes3.add(e7);
		etapes3.add(e8);
		Voyage v3 = new Voyage(120,etapes3);
		v3=voyageRepo.save(v3);
		e7.setVoyage(v3);
		etapeRepo.save(e7);
		e8.setVoyage(v3);
		etapeRepo.save(e8);		
		
		Etape e9 = new Etape(LocalDate.parse("2023-06-16"),p8,p1);
		Etape e10 = new Etape(e9.getDepart(),p1,p7);
		Etape e11 = new Etape(e10.getDepart(),p7,p2);
		Etape e12= new Etape(e11.getDepart(),p2,p4);
		List<Etape> etapes4 = new ArrayList<Etape>();
		etapes4.add(e9);
		etapes4.add(e10);
		etapes4.add(e11);
		etapes4.add(e12);
		Voyage v4 = new Voyage(220,etapes4);
		voyageRepo.save(v4);
		e9.setVoyage(v4);
		etapeRepo.save(e9);
		e10.setVoyage(v4);
		etapeRepo.save(e10);
		e11.setVoyage(v4);
		etapeRepo.save(e11);
		e12.setVoyage(v4);
		etapeRepo.save(e12);
		

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
		Passager pas4 = new Passager("Diot2","Arthur", LocalDate.parse("1996-05-03"));
		passagerRepo.save(pas4);
		Passager pas5 = new Passager("Diot3","Arthur", LocalDate.parse("1996-05-03"));
		passagerRepo.save(pas5);
		Passager pas6 = new Passager("Diot4","Arthur", LocalDate.parse("1996-05-03"));
		passagerRepo.save(pas6);
		Passager pas7 = new Passager("Diot5","Arthur", LocalDate.parse("1996-05-03"));
		passagerRepo.save(pas7);
		

		List<Passager> passagers1 = new ArrayList<Passager>();
		passagers1.add(pas1);
		passagers1.add(pas2);
		passagers1.add(pas3);
		Reservation r1 = new Reservation(v1,passagers1,c2);
		reservationRepo.save(r1);
		pas1.setReservation(r1);
		passagerRepo.save(pas1);
		pas2.setReservation(r1);
		passagerRepo.save(pas1);
		pas3.setReservation(r1);
		passagerRepo.save(pas1);
		
		List<Passager> passagers2 = new ArrayList<Passager>();
		passagers2.add(pas4);
		passagers2.add(pas5);
		Reservation r2 = new Reservation(v2,passagers2,c2);
		reservationRepo.save(r2);
		pas4.setReservation(r2);
		passagerRepo.save(pas4);
		pas5.setReservation(r2);
		passagerRepo.save(pas5);
		
		List<Passager> passagers3 = new ArrayList<Passager>();
		passagers3.add(pas6);
		passagers3.add(pas7);
		Reservation r3 = new Reservation(v3,passagers3,c2);
		reservationRepo.save(r3);
		pas6.setReservation(r3);
		passagerRepo.save(pas6);
		pas7.setReservation(r3);
		passagerRepo.save(pas7);
	}
}

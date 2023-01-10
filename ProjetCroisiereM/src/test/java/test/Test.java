package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dao.DAOCompte;
import model.Admin;
import model.Client;
import model.Equipage;
import model.Metier;
import model.Passager;
import model.Planete;
import model.Reservation;
import model.Voyage;

public class Test {
	
	static DAOCompte daoC = new DAOCompte();
		public static void menuPrincipal() {
		//connecter();  checkloginandpassword(String login, String password)
		//creeCompte(); daoC.insert();
	}
	public static void menuAdmin(){
		listeReservations(); // daoR.findall()
		listePassager();	//daoP.findall()
		listeDequipage();	//daoC.findAllEquipage()
		creerCompte();		//daoC.insert(compte c);
		supprimerCompte();  //daoC.delete(compte c)
		sedeconnecter();	//menuprincipal()
		//rajouter/enlever une planete dans le circuit
		
	}
	
	public static void menuClient() {
		reserver();				//daoR.insert()
		modifierReservation(); //daoR.upadate(reservation r)  + daoR.delete(reservation r)
		listeReservation(); // daoC.findAllById(id client)
		menuPrincipal();
	}
	public static void menuEquipage() {
		listeVoyage(); //daoV.findall()
	   //inspecterEtat();
		expulserVoyageur(); //DaoP.delete
		
	}
	public static Voyage listeVoyage(){
		return null;
	}
	

	
	public static Passager expulser(){
		return null;
	}
	
	
	public static void listeReservations() {
		
	}
	
	public static void creerCompte() {
		
	}
	
	public static void supprimerCompte() {
		
	}
	
	public static void reserver() {
		
	}
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Admin admin = new Admin("admin","admin","Hawkins","Jim");
		Equipage M1 = new Equipage("maint1","maint1","Salem","Rafiq",2000.0,Metier.valueOf("Maintenance"));
		Equipage M2 = new Equipage("maint2","maint2","R2","D2",0.0,Metier.valueOf("Maintenance"));
		Equipage P = new Equipage ("pilo","pilo","Diot","Arthur",2100.0,Metier.valueOf("Pilote"));
		Equipage S = new Equipage ("secu","secu","RA","Flo",2300.0,Metier.valueOf("Securite"));
		Client C1 = new Client("tpt","tpt","Duck","Donald");
		Client C2 = new Client("cli","cli","Skywalker","Anakin");
		
		List<Equipage> listeEquipages = new ArrayList();
		Collections.addAll(listeEquipages, M1,M2,P,S);
		
		Planete  pla1 = new Planete(4242,"Fairy Vearth",new double[] {10,-20,40});
		Planete  pla2 = new Planete(4242,"",new double[] {30,520,780});
		Planete  pla3 = new Planete(4242,"Arlong Park",new double[] {-700,30,650});
		
		Voyage V1 = new Voyage (listeEquipages, pla1, pla2);
		Voyage V2 = new Voyage (listeEquipages, pla1, pla3);
		
		Reservation R1 = new Reservation(V1,C1,2);
		Reservation R2 = new Reservation(V2,C2,3);
		
		
		Passager P1 = new Passager("Duck","Daisy",R1);
		Passager P2 = new Passager("Duck","Donald",R1);
		Passager P3 = new Passager("Kenobi","Obiwan",R2);
		Passager P4 = new Passager("Skywalker","Anakin",R2);
		Passager P5 = new Passager("Maitre","Yoda",R2);
		

		
		
	
	
	
	

}
	
	
	


}

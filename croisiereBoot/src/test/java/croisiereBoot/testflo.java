package croisiereBoot;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import croisiere.model.Etape;
import croisiere.model.Planete;
import croisiere.model.Voyage;

public class testflo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Planete planete1 = new Planete("test1", 0,5,10);
		Planete planete2 = new Planete("test2", 0, -5,20);
		Planete planete3 = new Planete("test3", 11, -15,40);
		Planete planete4 = new Planete("test4", -8, 50,0);
		
		
		
		
		Etape etape1 = new Etape(LocalDate.parse("2000-01-01"), planete1, planete2);
		
		
		
		Etape etape2 = new Etape(etape1.getArrivee(),etape1.getPlanetArrivee(), planete3);
		
		
		
		
		Etape etape3 = new Etape(etape2.getArrivee(), etape2.getPlanetArrivee(), planete4);
		etape3.tempstrajet();
		
		
		List<Etape> etapes = new ArrayList<>();
		etapes.add(etape1);
		etapes.add(etape2);
		etapes.add(etape3);
		
		Voyage voyage = new Voyage(30, etapes);
		
		voyage.calculDistance();
		
		voyage.calculDuree();
		
		voyage.calculPrix();
		
		
	}

}

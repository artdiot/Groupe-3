package croisiere.test;

import org.junit.BeforeClass;
import org.junit.Test;

import croisiere.context.Application;
import croisiere.model.Admin;
import croisiere.model.Client;
import croisiere.model.MembreEquipage;
import croisiere.model.Metier;
import croisiere.repository.jpa.CompteRepositoryjpa;
import org.junit.Assert;

public class TestCompte {

	
	public static CompteRepositoryjpa compteRepo;
	
	@BeforeClass
	public static void init(){
		compteRepo = (CompteRepositoryjpa) Application.getInstance().getCompteRepo();

		
	}

	@Test
	public void findById() {
		Admin a1 = new Admin("logina1","mdpa1","noma1","prenoma1","maila1",null);
		Client c1 = new Client("loginc1","mdpc1","nomc1","prenomc1","mailc1",null);
		MembreEquipage e1 = new MembreEquipage("loginm1","mdpm1","nomm1","prenomm1","mailm1",null,1000,
				Metier.MAINTENANCE, 0, true, 0);
		
		a1 = (Admin) compteRepo.save(a1);
		c1 = (Client) compteRepo.save(c1);
		e1 = (MembreEquipage) compteRepo.save(e1);
		
		Assert.assertEquals(c1.getNom(), compteRepo.findById(2).getNom());
	}
	


}

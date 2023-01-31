package croisiere.test;

import org.springframework.beans.factory.annotation.Autowired;

import croisiere.model.Planete;
import croisiere.repository.IPlaneteRepository;

public class Principal {	
	
	@Autowired
	IPlaneteRepository planeteRepo;
	
	public void run(String[] args) {

		Planete p = new Planete("Canartopia",0.0,1.0,0.0);
		planeteRepo.save(p);
		
	}

}
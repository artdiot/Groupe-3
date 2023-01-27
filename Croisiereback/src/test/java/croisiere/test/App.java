package croisiere.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import croisiere.context.Application;
import croisiere.model.Voyage;

public class App {
	public static void main(String[] args) {
		EntityManagerFactory emf = Application.getInstance().getEmf();

		EntityManager em = emf.createEntityManager(); // PersistenceContext Implicite
		EntityTransaction tx = em.getTransaction();
		
		//Voyage voyage = new Voyage();
		//em.persist(voyage);
		tx.begin();
		
		tx.commit();
		
		em.close();
		emf.close();
	}
}

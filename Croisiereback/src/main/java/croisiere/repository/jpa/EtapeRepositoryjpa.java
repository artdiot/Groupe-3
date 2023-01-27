package croisiere.repository.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import croisiere.context.Application;
import croisiere.model.Client;
import croisiere.model.Etape;
import croisiere.repository.IEtapeRepository;


public class EtapeRepositoryjpa implements IEtapeRepository{

	@Override
	public List<Etape> findAll() {
		List<Etape> etapes = new ArrayList<>();

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			TypedQuery<Etape> query = em.createQuery("select e from Etape e", Etape.class);

			etapes = query.getResultList();

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}

		return etapes;
	}

	@Override
	public Etape findById(Integer id) {
		Etape etape = null;

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			etape = em.find(Etape.class, id);

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}

		return etape;
	}

	@Override
	public Etape save(Etape o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Etape o) {
		// TODO Auto-generated method stub
		
	}

}

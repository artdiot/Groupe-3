package croisiere.repository.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import croisiere.model.Planete;
import croisiere.repository.IPlaneteRepository;
@Repository
public class PlaneteRepositoryjpa implements IPlaneteRepository{

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Planete> findAll() {
		List<Planete> planetes = new ArrayList<>();
		TypedQuery<Planete> query = em.createQuery("select p from Planete p", Planete.class);
		planetes = query.getResultList();
		return planetes;
	}

	@Override
	public Planete findById(Integer id) {
		Planete planete = null;
		planete = em.find(Planete.class, id);
		return planete;
	}

	@Override
	@Transactional
	public Planete save(Planete o) {
		o = em.merge(o);
		return o;
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		TypedQuery<Planete> query = em.createQuery("delete from Planete p where p.id = :id", Planete.class);
		query.setParameter("id", id);
		query.executeUpdate();
	}

	@Override
	@Transactional
	public void delete(Planete o) {
		em.remove(em.merge(o));
	}
}

package croisiere.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fasterxml.jackson.annotation.JsonView;

import croisiere.model.Etape;
import croisiere.model.Views;

public interface EtapeRepository extends JpaRepository<Etape,Integer>{
	@JsonView(Views.ViewEtape.class)
	List<Etape> findAllByOrderByDepartAsc();
	
}

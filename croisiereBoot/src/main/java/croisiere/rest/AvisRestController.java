package croisiere.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import croisiere.model.Avis;
import croisiere.model.Views;
import croisiere.repository.AvisRepository;

@RestController
@RequestMapping("/avis")
public class AvisRestController {
	@Autowired
	private AvisRepository avisRepository;


	@GetMapping("")
	@JsonView(Views.ViewAvis.class)
	public List<Avis> findAll() {
		List<Avis> aviss = avisRepository.findAll();

		return aviss;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewAvis.class)
	public Avis findById(@PathVariable Integer id) {
		Optional<Avis> optAvis = avisRepository.findById(id);

		if (optAvis.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optAvis.get();
	}



	@PostMapping("")
	@JsonView(Views.ViewAvis.class)
	public Avis create(@RequestBody Avis avis) {
		avis = avisRepository.save(avis);

		return avis;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewAvis.class)
	public Avis update(@RequestBody Avis avis, @PathVariable Integer id) {
		if (id != avis.getId()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		if (!avisRepository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		avis = avisRepository.save(avis);

		return avis;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		avisRepository.deleteById(id);
	}

}

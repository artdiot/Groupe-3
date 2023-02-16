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

import croisiere.model.Views;
import croisiere.model.Voyage;
import croisiere.repository.VoyageRepository;

@RestController
@RequestMapping("/voyage")
public class VoyageRestController {
	@Autowired
	private VoyageRepository voyageRepository;

	@GetMapping("")
	@JsonView(Views.ViewVoyage.class)
	public List<Voyage> findAll() {
		List<Voyage> voyages = voyageRepository.findAll();

		return voyages;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewVoyage.class)
	public Voyage findById(@PathVariable Integer id) {
		Optional<Voyage> optVoyage = voyageRepository.findById(id);

		if (optVoyage.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optVoyage.get();
	}

	@PostMapping("")
	@JsonView(Views.ViewVoyage.class)
	public Voyage create(@RequestBody Voyage voyage) {
		voyage = voyageRepository.save(voyage);

		return voyage;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewVoyage.class)
	public Voyage update(@RequestBody Voyage voyage, @PathVariable Integer id) {
		
		if (id != voyage.getId()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		if (!voyageRepository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		voyage = voyageRepository.save(voyage);

		return voyage;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		voyageRepository.deleteById(id);
	}

}

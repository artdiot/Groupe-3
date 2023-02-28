package croisiere.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import croisiere.model.Etape;
import croisiere.model.Views;
import croisiere.repository.EtapeRepository;

@RestController
@RequestMapping("/etape")
@CrossOrigin("*")
public class EtapeRestController {
	@Autowired
	private EtapeRepository etapeRepository;


	@GetMapping("")
	@JsonView(Views.ViewEtape.class)
	public List<Etape> findAll() {
		List<Etape> etapes = etapeRepository.findAllByOrderByDepartAsc();

		return etapes;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewEtape.class)
	public Etape findById(@PathVariable Integer id) {
		Optional<Etape> optEtape = etapeRepository.findById(id);

		if (optEtape.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optEtape.get();
	}



	@PostMapping("")
	@JsonView(Views.ViewEtape.class)
	public Etape create(@RequestBody Etape etape) {
		
		Etape etapeNew = new Etape(etape.getDepart(),etape.getPlanetDepart(),etape.getPlanetArrivee());
		etapeNew = etapeRepository.save(etapeNew);

		return etapeNew;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewEtape.class)
	public Etape update(@RequestBody Etape etape, @PathVariable Integer id) {
		if (id != etape.getId()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		if (!etapeRepository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		etape = etapeRepository.save(etape);

		return etape;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		etapeRepository.deleteById(id);
	}

}

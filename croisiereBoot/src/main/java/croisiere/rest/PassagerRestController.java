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

import croisiere.model.Passager;
import croisiere.model.Views;
import croisiere.repository.PassagerRepository;

@RestController
@RequestMapping("/passager")
@CrossOrigin("*")
public class PassagerRestController {
	@Autowired
	private PassagerRepository passagerRepository;

	@GetMapping("")
	@JsonView(Views.ViewPassager.class)
	public List<Passager> findAll() {
		List<Passager> passagers = passagerRepository.findAll();

		return passagers;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewPassager.class)
	public Passager findById(@PathVariable Integer id) {
		Optional<Passager> optPassager = passagerRepository.findById(id);

		if (optPassager.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optPassager.get();
	}

	@PostMapping("")
	@JsonView(Views.ViewPassager.class)
	public Passager create(@RequestBody Passager passager) {
		passager = passagerRepository.save(passager);

		return passager;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewPassager.class)
	public Passager update(@RequestBody Passager passager, @PathVariable Integer id) {
		
		if (id != passager.getId()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		if (!passagerRepository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		passager = passagerRepository.save(passager);

		return passager;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		passagerRepository.deleteById(id);
	}

}

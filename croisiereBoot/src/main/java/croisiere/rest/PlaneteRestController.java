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

import croisiere.model.Planete;
import croisiere.model.Views;
import croisiere.repository.PlaneteRepository;

@RestController
@RequestMapping("/planete")
@CrossOrigin("*")
public class PlaneteRestController {
	@Autowired
	private PlaneteRepository planeteRepository;


	@GetMapping("")
	@JsonView(Views.ViewPlanete.class)
	public List<Planete> findAll() {
		List<Planete> planetes = planeteRepository.findAll();

		return planetes;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewPlanete.class)
	public Planete findById(@PathVariable Integer id) {
		Optional<Planete> optPlanete = planeteRepository.findById(id);

		if (optPlanete.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optPlanete.get();
	}



	@PostMapping("")
	@JsonView(Views.ViewPlanete.class)
	public Planete create(@RequestBody Planete planete) {
		planete = planeteRepository.save(planete);

		return planete;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewPlanete.class)
	public Planete update(@RequestBody Planete planete, @PathVariable Integer id) {
		if (id != planete.getId()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		if (!planeteRepository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		planete = planeteRepository.save(planete);

		return planete;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		planeteRepository.deleteById(id);
	}

}

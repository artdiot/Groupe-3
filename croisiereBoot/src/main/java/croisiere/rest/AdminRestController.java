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

import croisiere.model.Admin;
import croisiere.model.Views;
import croisiere.repository.AdminRepository;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminRestController  {
	@Autowired
	private AdminRepository adminRepository;

	@GetMapping("")
	@JsonView(Views.ViewAdmin.class)
	public List<Admin> findAll() {
		List<Admin> admins = adminRepository.findAll();

		return admins;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewAdmin.class)
	public Admin findById(@PathVariable Integer id) {
		Optional<Admin> optAdmin = adminRepository.findById(id);

		if (optAdmin.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optAdmin.get();
	}

	@PostMapping("")
	@JsonView(Views.ViewAdmin.class)
	public Admin create(@RequestBody Admin admin) {
		admin = adminRepository.save(admin);

		return admin;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewAdmin.class)
	public Admin update(@RequestBody Admin admin, @PathVariable Integer id) {
		
		if (id != admin.getId()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		if (!adminRepository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		admin = adminRepository.save(admin);

		return admin;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		adminRepository.deleteById(id);
	}

}

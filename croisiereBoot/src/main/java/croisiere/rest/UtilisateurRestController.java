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

import croisiere.model.Utilisateur;
import croisiere.model.Views;
import croisiere.repository.ClientRepository;
import croisiere.repository.UtilisateurRepository;
import croisiere.rest.dto.AuthDTO;

@RestController
@RequestMapping("/utilisateur")
@CrossOrigin("*")
public class UtilisateurRestController {
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	@Autowired
	private ClientRepository clientRepository;

	@GetMapping("")
	@JsonView(Views.ViewUtilisateur.class)
	public List<Utilisateur> findAll() {
		List<Utilisateur> utilisateurs = utilisateurRepository.findAll();

		return utilisateurs;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewUtilisateur.class)
	public Utilisateur findById(@PathVariable Integer id) {
		Optional<Utilisateur> optUtilisateur = utilisateurRepository.findById(id);

		if (optUtilisateur.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optUtilisateur.get();
	}

	@PostMapping("")
	@JsonView(Views.ViewUtilisateur.class)
	public Utilisateur create(@RequestBody Utilisateur utilisateur) {
		utilisateur = utilisateurRepository.save(utilisateur);

		return utilisateur; 
	}
	
	@PostMapping("/inscription/client/{id}")
	@JsonView(Views.ViewUtilisateur.class)
	public Utilisateur inscription(@RequestBody Utilisateur utilisateur, @PathVariable Integer id) {
		if(clientRepository.findById(id).isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		utilisateur.setCompte(clientRepository.findById(id).get());
		
		return utilisateurRepository.save(utilisateur);
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewUtilisateur.class) 
	public Utilisateur update(@RequestBody Utilisateur utilisateur, @PathVariable Integer id) {
		if (id != utilisateur.getId()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		if (!utilisateurRepository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		utilisateur = utilisateurRepository.save(utilisateur);

		return utilisateur;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		utilisateurRepository.deleteById(id);
	}
	
	@PostMapping("/auth")
	@JsonView(Views.ViewUtilisateur.class)
	public Utilisateur auth(@RequestBody AuthDTO authDTO) {
		Optional<Utilisateur> optUtilisateur = utilisateurRepository.findByLoginAndMotDePasse(authDTO.getLogin(), authDTO.getPassword());
	
		if(optUtilisateur.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return optUtilisateur.get();	
	}
}

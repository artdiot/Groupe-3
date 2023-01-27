package croisiere.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "crew_travel")
public class EquipageVoyage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "travel_id")
	private Voyage voyage;
	
	@ManyToOne
	@JoinColumn(name = "crew_member_id")
	private MembreEquipage equipage;
}

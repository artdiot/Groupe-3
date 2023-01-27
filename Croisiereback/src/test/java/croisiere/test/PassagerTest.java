package croisiere.test;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import croisiere.context.Application;
import croisiere.model.Passager;
import croisiere.model.Reservation;
import croisiere.repository.IAvisRepository;
import croisiere.repository.IPassagerRepository;
import croisiere.repository.IReservationRepository;


public class PassagerTest {

	private static IAvisRepository avisRepo;
	private static IPassagerRepository passagerRepo;
	private static IReservationRepository reservationRepo;
	
	@BeforeClass
	public static void initAllTest() {
		avisRepo = Application.getInstance().getAvisRepo();
		passagerRepo = Application.getInstance().getPassagerRepo();
		reservationRepo = Application.getInstance().getReservationRepo();
	
	}
	
	@Test
	public void creation() {
		
		Reservation resa = new Reservation(3.0,LocalDate.parse("2023-05-01"),3);
		
		//Act
		Passager passager = new Passager("flo","RA",LocalDate.parse("1993-05-03"));
		passager.setReservation(resa);
		passager = passagerRepo.save(passager);
		
		//Assert
		
		Passager passagerFind = passagerRepo.findById(passager.getId());
		Assert.assertEquals("flo", passagerFind.getNom());
		Assert.assertEquals("RA", passagerFind.getPrenom());
		Assert.assertEquals(LocalDate.parse("1993-05-03"), passagerFind.getDateNaissance());
		Assert.assertEquals(resa.getPrix(), passagerFind.getReservation().getPrix(),0.001);
		Assert.assertEquals(LocalDate.parse("2023-05-03"), passagerFind.getReservation().getDate());
		Assert.assertEquals(3, passagerFind.getReservation().getDate());
		
		
		
	}
	
}

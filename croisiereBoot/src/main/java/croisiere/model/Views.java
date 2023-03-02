package croisiere.model;

public class Views {
	
	public class ViewBase{
	}
	
	public class ViewReservation extends ViewReservationInfo{
	}
	
	public class ViewReservationWithEtapes extends ViewReservation{
	}
	
	public class ViewReservationInfo extends ViewBase{
	}
	
	
	public class ViewVoyage extends ViewBase{
		
	}

	
	public class ViewEtape extends ViewBase{
		
	}
	
	public class ViewCompte extends ViewBase{
	}
	
	public class ViewClient extends ViewCompte{
	}
	public class ViewAdmin extends ViewCompte{
		
	}
	public class ViewPlanete extends ViewBase{
	}
	
	public class ViewAvis extends ViewBase{
	}
	
	public class ViewPassager extends ViewReservationInfo{
		
	}
	
	public class ViewUtilisateur extends ViewBase{
		
	}
	
	
}

	

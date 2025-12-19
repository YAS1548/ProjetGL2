package strategy;
import model.Club;
import model.User;

public class PrioriteClubStrategy implements PolitiqueReservationStrategy{
	

	@Override
	public boolean estPrioritaire(User u1, User u2) {
		return u1 instanceof Club;
	}

}

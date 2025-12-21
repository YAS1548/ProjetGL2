package strategy;

import model.Club;
import model.User;

public class PrioriteClubStrategy implements PolitiqueReservationStrategy {

	@Override
	public boolean estPrioritaire(User u1, User u2) {

		boolean u1EstClub = u1 instanceof Club;
		boolean u2EstClub = u2 instanceof Club;

		return u1EstClub && !u2EstClub;
	}

}
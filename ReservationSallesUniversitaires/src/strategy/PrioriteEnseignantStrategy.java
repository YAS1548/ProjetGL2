package strategy;

import model.Enseignant;
import model.User;

public class PrioriteEnseignantStrategy implements PolitiqueReservationStrategy {

	@Override
	public boolean estPrioritaire(User u1, User u2) {

		boolean u1EstEnseignant = u1 instanceof Enseignant;
		boolean u2EstEnseignant = u2 instanceof Enseignant;

		return u1EstEnseignant && !u2EstEnseignant;
	}

}
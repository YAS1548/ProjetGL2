package strategy;
import model.User;
import model.Enseignant;

public class PrioriteEnseignantStrategy implements PolitiqueReservationStrategy{

	@Override
	public boolean estPrioritaire(User u1, User u2) {
		return u1 instanceof Enseignant;
	}

}

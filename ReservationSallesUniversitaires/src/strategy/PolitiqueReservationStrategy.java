package strategy;

import model.User;

public interface PolitiqueReservationStrategy {

	boolean estPrioritaire(User u1, User u2);

}

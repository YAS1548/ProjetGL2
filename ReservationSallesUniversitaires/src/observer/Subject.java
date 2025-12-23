package observer;

import observer.Observer;

public interface Subject {

	void addObserver(Observer o);

	void removeObserver(Observer o);

	void notifyObserver(String message);

}

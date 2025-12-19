package model;
import observer.Observer;

public class User implements Observer{
	protected int id;
	protected String nom;
	
	public User(int id, String nom) {
		this.id=id;
		this.nom=nom;
	}

	@Override
	public void notifier(String message) {
			System.out.println("Notification pour "+nom+":"+message);
			
	}
	
	public String getNom() {
		return nom;
	}
	
	
	
}

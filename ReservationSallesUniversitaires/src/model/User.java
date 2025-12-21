package model;
import observer.Observer;

import java.util.Objects;

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

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof User)) return false;
		User u = (User) obj;
		return id == u.id && nom.equals(u.nom);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nom);
	}
	
	
	
}
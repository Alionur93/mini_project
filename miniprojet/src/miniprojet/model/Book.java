package miniprojet.model;

import java.io.Serializable;

public class Book implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private boolean reserv;
	private String owner;
	
	public Book(String name, boolean reserv, String owner) {
		
		this.name=name;
		this.reserv=reserv;
		this.owner=owner;
	}

	public Book(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isReserv() {
		return reserv;
	}

	public void setReserv(boolean reserv) {
		this.reserv = reserv;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	
}

package eCommerceDemo.entities.concretes;

import eCommerceDemo.entities.abstracts.Entity;

public class Email implements Entity{

	private String message;

	public Email() {
		
	}
	
	public Email(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}

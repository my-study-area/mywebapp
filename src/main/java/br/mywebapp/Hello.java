package br.mywebapp;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class Hello implements Serializable{

	private static final long serialVersionUID = 1L;

	public Hello() {
		message = "Estou usando CDI";	
	}

	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String Message) {
		this.message = Message;
	}

}


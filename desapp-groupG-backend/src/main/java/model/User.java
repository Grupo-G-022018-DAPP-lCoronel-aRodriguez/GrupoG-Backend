package model;

import exceptions.*;

import java.time.LocalDate;
import java.time.LocalTime;

public class User {
	private String name;
	private String surname;
	private String email;
	private String password;
	private LocalDate birth;
	private Boolean logged = false;
	
	
	//Getters, Setters
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) throws InvalidNameException {
		if (Validator.isValidName(name))
			{ this.name = name; }
		else
			{ throw new InvalidNameException(); }
	}

	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) throws InvalidSurnameException {
		if (Validator.isValidSurname(surname))
			{ this.surname = surname; }
		else
			{ throw new InvalidSurnameException(); }
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) throws InvalidEmailException {
		if (Validator.isValidEmail(email))
			{ this.email = email; }
		else
			{ throw new InvalidEmailException(); }
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) throws InvalidPasswordException {
		if (Validator.isValidPassword(password))
			{ this.password = password; }
		else
			{ throw new InvalidPasswordException(); }
	}

	public LocalDate getBirth() {
		return birth;
	}
	
	public void setBirth(LocalDate birth) throws InvalidBirthException {
		if (Validator.isValidDate(birth))
			{ this.birth = birth; }
		else
			{ throw new InvalidBirthException(); }
	}
	
	
	// Methods
	
	public void createAuction(String title, String description, Integer price, LocalDate start, LocalDate end, LocalTime endHour){
	    //TODO: only for registered users
		Auction newAuction = new Auction(title,description, price, start, end, endHour);

		newAuction.setOwnerEmail(this.getEmail());
	}

}

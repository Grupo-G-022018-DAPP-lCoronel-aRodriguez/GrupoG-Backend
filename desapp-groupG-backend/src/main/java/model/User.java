package model;

import java.time.LocalDate;
import java.time.LocalTime;

import exceptions.InvalidBirthException;
import exceptions.InvalidEmailException;
import exceptions.InvalidNameException;
import exceptions.InvalidPasswordException;
import exceptions.InvalidSurnameException;

public class User {
	private String name;
	private String surname;
	private String email;
	private String password;
	private LocalDate birth;
	private Boolean logged = false;
	
	
	//Getters, Setters, Validation
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) throws InvalidNameException {
		if (isValidName(name))
			{ this.name = name; }
		else
			{ throw new InvalidNameException(); }
	}
	
	private boolean isValidName(String name) {
		return name.length() >= 1 && name.length() < 30;
	}

	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) throws InvalidSurnameException {
		if (isValidSurname(surname))
			{ this.surname = surname; }
		else
			{ throw new InvalidSurnameException(); }
	}
	
	private boolean isValidSurname(String surname) {
		return isValidName(surname);
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) throws InvalidEmailException {
		if (isValidEmail(email))
			{ this.email = email; }
		else
			{ throw new InvalidEmailException(); }
	}
	
	private boolean isValidEmail(String email) {
		//TODO better validation (e.g .com.ar)
		return email.contains("@") && email.endsWith(".com");
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) throws InvalidPasswordException {
		if (isValidPassword(password))
			{ this.password = password; }
		else
			{ throw new InvalidPasswordException(); }
	}
	
	private boolean isValidPassword(String password) {
		//TODO check password contains only alphanumeric characters
		return password.length() >= 4 && password.length() < 30;
	}

	public LocalDate getBirth() {
		return birth;
	}
	
	public void setBirth(LocalDate birth) throws InvalidBirthException {
		if (isValidDate(birth))
			{ this.birth = birth; }
		else
			{ throw new InvalidBirthException(); }
	}
	
	private boolean isValidDate(LocalDate birth) {
		//return birth.after(Date(1,1,1990);
		//TODO validar la fecha, tiene que ser antes de hoy y despues de 1900
		//TODO validar formato DD/MM/YYYY, validar +18
		return true;
	}
	
	
	// Methods
	
	public void createAuction(String title, String description, Integer price, LocalDate start, LocalDate end, LocalTime endHour){
	    //TODO: only for registered users
		Auction newAuction = new Auction(title,description, price, start, end, endHour);

		newAuction.setOwnerEmail(this.getEmail());
	}

}

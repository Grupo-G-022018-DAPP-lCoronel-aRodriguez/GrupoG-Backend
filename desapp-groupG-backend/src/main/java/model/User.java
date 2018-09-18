package model;

import exceptions.*;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

public class User {
	@NotNull private String name;
    @NotNull private String surname;
    @NotNull private String email;
    @NotNull private String password;
    @NotNull private LocalDate birth;
	private Boolean logged = false;
	
	
	//Getters, Setters
	
	@NotNull
    public String getName() {
		return name;
	}
	
	public void setName(String name) throws InvalidNameException {
		if (Validator.isValidName(name))
			{ this.name = name; }
		else
			{ throw new InvalidNameException(); }
	}

	@NotNull
    public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) throws InvalidSurnameException {
		if (Validator.isValidSurname(surname))
			{ this.surname = surname; }
		else
			{ throw new InvalidSurnameException(); }
	}

	@NotNull
    public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) throws InvalidEmailException {
		if (Validator.isValidEmail(email))
			{ this.email = email; }
		else
			{ throw new InvalidEmailException(); }
	}

	@NotNull
    public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) throws InvalidPasswordException {
		if (Validator.isValidPassword(password))
			{ this.password = password; }
		else
			{ throw new InvalidPasswordException(); }
	}

	@NotNull
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
	
    public String viewDetails(Auction auction){
	    //TODO el detalle de la subasta cambia segun su estado
	    String title = auction.getTitle();
	    String desc = auction.getDescription();

	    return title + "\n\n" + desc;
    }

}

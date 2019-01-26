package ar.edu.unq.desapp.grupog.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import ar.edu.unq.desapp.grupog.exceptions.InvalidBirthException;
import ar.edu.unq.desapp.grupog.exceptions.InvalidEmailException;
import ar.edu.unq.desapp.grupog.exceptions.InvalidNameException;
import ar.edu.unq.desapp.grupog.exceptions.InvalidPasswordException;
import ar.edu.unq.desapp.grupog.exceptions.InvalidSurnameException;
import ar.edu.unq.desapp.grupog.validator.Validator;

@Entity
@Table(name = "user")
public class User implements Observer {
	@NotNull private String name;
    @NotNull private String surname;
    @NotNull private String email;
    @NotNull private String password;
    @NotNull private LocalDate birth;
	private Long id;
	private String username;
	private Set<Auction> auctions;
	private UserState state;
	
	//Getters, Setters
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

	
	@NotNull String getName() {
		return name;
	}
	
	void setName(String name) throws InvalidNameException {
		if (Validator.isValidName(name))
			{ this.name = name; }
		else
			{ throw new InvalidNameException(); }
	}

	@NotNull String getSurname() {
		return surname;
	}
	
	void setSurname(String surname) throws InvalidSurnameException {
		if (Validator.isValidSurname(surname))
			{ this.surname = surname; }
		else
			{ throw new InvalidSurnameException(); }
	}

	@NotNull String getEmail() {
		return email;
	}
	
	void setEmail(String email) throws InvalidEmailException {
		if (Validator.isValidEmail(email))
			{ this.email = email; }
		else
			{ throw new InvalidEmailException(); }
	}

    String getPassword() {
        return password;
    }

    void setPassword(String password) throws InvalidPasswordException {
    	if(Validator.isValidPassword(password))
    		{ this.password = password; }
    	else { throw new InvalidPasswordException(); }
        
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

	void setState(UserRegistered state) {
		this.state = state;
	}

    @ManyToMany
    @JoinTable(name = "user_auction", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "auction_id"))
    public Set<Auction> getAuctions() {
        return auctions;
    }

    public void setAuctions(Set<Auction> auctions) {
        this.auctions = auctions;
    }

	
	// Methods
	
    public String viewDetails(Auction auction){
	    //TODO el detalle de la subasta cambia segun su estado
	    String title = auction.getTitle();
	    String desc = auction.getDescription();

	    return title + "\n\n" + desc;
    }
	
	
	Auction createAuction(String title, String description, Float price, LocalDate start, LocalDate end, LocalTime endHour){
		return this.state.createAuction(title,description, price, start, end, endHour, this.email);
    }

    void bidAuction(Auction auction) {
    	this.state.bidAuction(auction, this.email);
    }


	@Override
	public void update(Observable auction, Object arg) {
			this.state.bidAuction((Auction) auction, this.email);
	}
}

package ar.edu.unq.desapp.grupoG.model;

import java.time.LocalDate;
import java.time.LocalTime;
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
import ar.edu.unq.desapp.grupoG.exceptions.InvalidBirthException;
import ar.edu.unq.desapp.grupoG.exceptions.InvalidEmailException;
import ar.edu.unq.desapp.grupoG.exceptions.InvalidNameException;
import ar.edu.unq.desapp.grupoG.exceptions.InvalidPasswordException;
import ar.edu.unq.desapp.grupoG.exceptions.InvalidSurnameException;
import ar.edu.unq.desapp.grupoG.validator.Validator;

@Entity
@Table(name = "user")
public class User{
	@NotNull private String name;
    @NotNull private String surname;
    @NotNull private String email;
  @NotNull private String password;
    @NotNull private LocalDate birth;
	private Long id;
	private String username;
	private Set<Auction> auctions;//no lo uso aun
	private UserState state;
	private AutomaticBid automatic;

	
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws InvalidPasswordException {
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
	
//    @Transient
//    public String getPasswordConfirm() {
//        return passwordConfirm;
//    }
//
//    public void setPasswordConfirm(String passwordConfirm) {
//        this.passwordConfirm = passwordConfirm;
//    }
//
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
	
	
	public Auction createAuction(String title, String description, Integer price, LocalDate start, LocalDate end, LocalTime endHour){

		return this.state.createAuction(title,description, price, start, end, endHour, this.email);
		
    }

    public void bidAuction(Auction auction){

    	this.state.bidAuction(auction, this.email);
    	
        }
    
    public void bidAutomaticaly(Auction auction, Float aPrice) {
    	if (auction.getLastBidderName() == null) {
    		//si soy el primero en ofertar 
    		this.automatic = new AutomaticBid(this,auction,aPrice);
    	}
    }
    

}

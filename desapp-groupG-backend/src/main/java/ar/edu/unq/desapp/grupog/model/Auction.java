package ar.edu.unq.desapp.grupog.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import javax.persistence.*;


//@Observable
@Entity(name="Auction")
@Table(name = "auction")

public class Auction extends Observable {
	private @Id @GeneratedValue(strategy = GenerationType.AUTO) Long id;

	private String title;
	private String description;
	private String address;
	private String photoURL;
	private Float initialPrice;
	private Float currentPrice;
	private LocalDate untilDate;
	private LocalTime untilTime;
	private AuctionState auctionState;
	private String ownerEmail;
	private String lastBidderName = null;
	private LocalDate publicationDate;

	@OneToMany(mappedBy = "auction", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<History> historial = new ArrayList<>();

	
	public Auction(String title, String description, Float price, LocalDate start, LocalDate end, LocalTime endHour) {
		this.title = title;
		this.description = description;
		this.initialPrice = price;
		this.currentPrice = price;

		this.setPublicationDate(start);
		this.untilDate = end;
		this.untilTime = endHour;
		this.historial = new ArrayList<>();

		this.publicationDate = LocalDate.now();

		this.auctionState = new NewState();
	}
	
	public Auction(String title, String description) {
		this.title = title;
		this.description = description;
	}

	public Auction() {}

    public Long getId() {
        return id;
    }
	
    public void setId(Long id) {
        this.id = id;
    }

	String getTitle() {
		return title;
	}
	
	LocalDate getUntilDate() {
		return untilDate;
	}

	LocalTime getUntilTime() {
		return untilTime;
	}

	String getLastBidderName() {
		return lastBidderName;
	}

	void setLastBidderName(String lastBidderName) {
		this.lastBidderName = lastBidderName;
	}

	String getDescription() {
		return description;
	}

	String getAddress() {
		return address;
	}

	void setAddress(String address) {
		this.address = address;
	}

	String getPhotoURL() {
		return photoURL;
	}

	void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}

	Float getInitialPrice() {
		return initialPrice;
	}
	

	public AuctionState getAuctionState() {
		return auctionState;
	}

	public void setAuctionState(AuctionState auctionState) {
		this.auctionState = auctionState;
	}

	String getOwnerEmail() {
		return ownerEmail;
	}

	void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}

	private void setCurrentPrice(Float currentPrice) {
		this.currentPrice = currentPrice;
	}

	Float getCurrentPrice() {
		return currentPrice;
	}

	/*
	public String getName() {
	return name;
	}

	public void setName(String name) {
	this.name = name;
	}

    
    @ManyToMany(mappedBy = "auctions")
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
*/

	// Methods

    private void addHistory(History history) {
        this.historial.add(history);
        history.setAuction(this);
    }

	void acceptBid(String email) {
		// TODO chequear estado InProgress
		//this.historial.add(new History(this.lastBidderName,this.currentPrice, this));
        this.addHistory(new History(this.lastBidderName,this.currentPrice, this));
		this.setCurrentPrice( (float)(getCurrentPrice() + (getCurrentPrice() * 0.5)));
		this.setLastBidderName(email);
		this.setChanged();
		notifyObservers();
		//antes de sobreecribir el precio, guardamos el precio anterior y ultimo usuario anterior en la lista
	}

	LocalDate getPublicationDate() {
		return publicationDate;
	}

	private void setPublicationDate(LocalDate publicationDate) {
		this.publicationDate = publicationDate;
	}

	void printHistory(){
		this.historial.forEach(History::print);
	}

}

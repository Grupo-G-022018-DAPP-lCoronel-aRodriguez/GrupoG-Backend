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
		this.currentPrice = price; // comienza siendo igual que el valor inicial

		this.setPublicationDate(start);
		this.untilDate = end;
		this.untilTime = endHour;
		this.historial = new ArrayList <History>();

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
	

	public String getTitle() {
		return title;
	}
	
	public LocalDate getUntilDate() {
		return untilDate;
	}

	public void setUntilDate(LocalDate untilDate) {
		this.untilDate = untilDate;
	}

	public LocalTime getUntilTime() {
		return untilTime;
	}

	public void setUntilTime(LocalTime untilTime) {
		this.untilTime = untilTime;
	}

	public String getLastBidderName() {
		return lastBidderName;
	}

	public void setLastBidderName(String lastBidderName) {
		this.lastBidderName = lastBidderName;
	}

	public List<History> getHistorial(){
		return this.historial;
	}

	public String getDescription() {
		return description;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhotoURL() {
		return photoURL;
	}

	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}

	public Float getInitialPrice() {
		return initialPrice;
	}
	

	public AuctionState getAuctionState() {
		return auctionState;
	}

	public void setAuctionState(AuctionState auctionState) {
		this.auctionState = auctionState;
	}

	public String getOwnerEmail() {
		return ownerEmail;
	}

	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}

	private void setCurrentPrice(Float currentPrice) {
		this.currentPrice = currentPrice;
	}

	public Float getCurrentPrice() {
		return currentPrice;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setInitialPrice(Float initialPrice) {
		this.initialPrice = initialPrice;
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

    public void addHistory(History history) {
        this.historial.add(history);
        history.setAuction(this);
    }

	public void acceptBid(String email) {
		// TODO chequear estado InProgress
		//this.historial.add(new History(this.lastBidderName,this.currentPrice, this));
        this.addHistory(new History(this.lastBidderName,this.currentPrice, this));
		this.setCurrentPrice( (float)(getCurrentPrice() + (getCurrentPrice() * 0.5)));
		this.setLastBidderName(email);
		this.setChanged();
		notifyObservers();
		//antes de sobreecribir el precio, guardamos el precio anterior y ultimo usuario anterior en la lista
	}

	public LocalDate getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(LocalDate publicationDate) {
		this.publicationDate = publicationDate;
	}

	public void printHistory(){
		this.historial.forEach(History::print);
	}

}

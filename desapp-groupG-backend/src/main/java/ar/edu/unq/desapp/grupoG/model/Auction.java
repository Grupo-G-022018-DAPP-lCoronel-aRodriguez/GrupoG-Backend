package ar.edu.unq.desapp.grupoG.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


//@Observable
@Entity
@Table(name = "auction")
public class Auction {
	private @Id @GeneratedValue(strategy = GenerationType.AUTO) Long id;
	private String title;
	private String description;
	private String address;
	private String photoURL;
	private Integer initialPrice;
	private Integer currentPrice;
	private LocalDate untilDate;
	private LocalTime untilTime;
	//private AuctionState auctionState;
	private String ownerEmail;
	private String lastBidderName = null;
	//private List<Integer> previousPrices ; // la lista de precios anteriores
	private LocalDate publicationDate;
	
//	private String name;
    //private Set<User> users;


	
	public Auction(String title, String description, Integer price, LocalDate start, LocalDate end, LocalTime endHour) {
		this.title = title;
		this.description = description;
		this.initialPrice = price;
		this.currentPrice = price; // comienza siendo igual que el valor inicial

		this.setPublicationDate(start);
		this.untilDate = end;
		this.untilTime = endHour;
		//this.previousPrices = new ArrayList <Integer>();
		//this.previousPrices.add(0);

		//this.auctionState = new NewState();
		
	}
	
	public Auction(String title, String description) {
		this.title = title;
		this.description = description;
	}
	

	public Auction() {}

	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

//	public ArrayList<Integer> getPreviousPrices() {
	//	return getPreviousPrices();
	//}

	public void setPreviousPrices(List<Integer> previousPrices) {
		//this.previousPrices = previousPrices;
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

	public Integer getInitialPrice() {
		return initialPrice;
	}
	
	/*
	public AuctionState getAuctionState() {
		return auctionState;
	}*/
	
	/*
	public void setAuctionState(AuctionState auctionState) {
		this.auctionState = auctionState;
	}*/

	public String getOwnerEmail() {
		return ownerEmail;
	}

	void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}

	private void setCurrentPrice(Integer currentPrice) {
		this.currentPrice = currentPrice;
		//notify()
	}

	public Integer getCurrentPrice() {
		return currentPrice;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setInitialPrice(Integer initialPrice) {
		this.initialPrice = initialPrice;
	}
	
//	public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
    
    /*@ManyToMany(mappedBy = "auctions")
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }*/





	// Methods

	void acceptBid(String email) {
		// TODO chequear estado InProgress

		this.setCurrentPrice((int) (getInitialPrice() + (getInitialPrice() * 0.5)));
		this.setLastBidderName(email);
	}

	public LocalDate getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(LocalDate publicationDate) {
		this.publicationDate = publicationDate;
	}

}

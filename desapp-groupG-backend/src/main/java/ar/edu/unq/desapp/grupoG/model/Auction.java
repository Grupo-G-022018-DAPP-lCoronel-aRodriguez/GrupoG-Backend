package ar.edu.unq.desapp.grupoG.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Auction {
	private String title;
    private String description;
	private String address;
	private String photoURL;
    private Integer initialPrice;
	private Integer currentPrice;

    private LocalDate publicationDate;
    private LocalDate untilDate;
    private LocalTime untilTime;

	private AuctionState auctionState;
	private String ownerEmail;
	private String lastBidderName = null;
	private List previousPrices = null; // la lista de precios anteriores

    public Auction(String title, String description, Integer price, LocalDate start, LocalDate end, LocalTime endHour){
        this.title = title;
        this.description = description;
        this.initialPrice = price;
        this.currentPrice = price; //comienza siendo igual que el valor inicial

        this.publicationDate = start;
        this.untilDate = end;
        this.untilTime = endHour;

        this.auctionState = new NewState();
    }


    public String getTitle() {
		return title;
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

	public AuctionState getAuctionState() {
		return auctionState;
	}

	public void setAuctionState(AuctionState auctionState) {
		this.auctionState = auctionState;
	}

	public String getOwnerEmail() {
		return ownerEmail;
	}

	void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}

    private void setCurrentPrice(Integer currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Integer getCurrentPrice() {
        return currentPrice;
    }

	//Methods

    void acceptBid() {
        //TODO chequear estado InProgress
        this.setCurrentPrice((int) (getInitialPrice() + (getInitialPrice() * 0.5)));
    }

}

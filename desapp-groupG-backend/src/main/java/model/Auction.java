package model;

import java.time.LocalDate;
import java.util.List;

public class Auction {
	private String title;
	private String description;
	private String address;
	private String photoURL;
	private Integer initialPrice;

    private LocalDate publicationDate;
	private LocalDate untilDate;

	private State state;
	private String ownerEmail;
	private String lastBidderName = null;
	private List previousPrices = null; // la lista de precios anteriores

    public Auction(String title, String description, String address, Integer price){
        this.title = title;
        this.description = description;
        this.address = address;
        this.initialPrice = price;

        this.publicationDate = LocalDate.now();
        this.state = new NewState();
    }


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public void setInitialPrice(Integer initialPrice) {
		this.initialPrice = initialPrice;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public String getOwnerEmail() {
		return ownerEmail;
	}

	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}
}

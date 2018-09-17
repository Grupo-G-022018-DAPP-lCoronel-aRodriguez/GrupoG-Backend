package model;

import java.util.Date;
import java.util.List;

public class Auction {
	private String tittle;
	private String description;
	private String address;
	private String photoURL;
	private Integer price;//por simplicidad Integer, luego veremos cual queda mejor
	private Date publicationDate;
	private Date untilDate;
	private State state;
	private String ownerEmail;
	private String lastBidderName = null;
	private List previousPrices = null; // la lista de precios anteriores


	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
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

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
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

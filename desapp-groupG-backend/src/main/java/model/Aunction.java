package model;

import java.util.Date;
import java.util.List;

public class Aunction {
	private String tittle;
	private String description;
	private String address;
	private String photoURL;
	private Integer price;//por simplicidad Integer, luego veremos cual queda mejor
	private Date publicationDate;
	private Date untilDate;
	private State state;
	private String ownerEmail;
	private String lastBidderName;
	private List previousPrices; // la lista de precios anteriores
	
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
	public Date getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}
	public Date getUntilDate() {
		return untilDate;
	}
	public void setUntilDate(Date untilDate) {
		this.untilDate = untilDate;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	
	

}

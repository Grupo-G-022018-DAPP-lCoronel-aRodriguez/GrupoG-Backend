package ar.edu.unq.desapp.grupoG.model;

import java.time.LocalDate;

public class History {
	String userEmail;
	Float price;
	LocalDate date;
	Long auctionId;
	
	
	public History (String email, Float price, Long auction) {
		this.userEmail=email;
		this.price=price;
		this.date = LocalDate.now();
		this.auctionId = auction;
	}

}

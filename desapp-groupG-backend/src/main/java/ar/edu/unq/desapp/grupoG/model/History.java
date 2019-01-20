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

	public void print(){
		System.out.print("\n");
		System.out.print(this.userEmail);
		System.out.print("\n");
		System.out.print(this.price);
		System.out.print("\n");
		System.out.print(this.date);
		System.out.print("\n");
		System.out.print(this.auctionId);
		System.out.print("\n");
		System.out.print("\n");
	}

}

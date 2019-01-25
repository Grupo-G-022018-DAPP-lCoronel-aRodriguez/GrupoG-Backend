package ar.edu.unq.desapp.grupog.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

import javax.validation.constraints.NotNull;

//@Observer
public class UserRegistered extends UserState {


	@Override
	public void bidAuction(Auction auction, @NotNull String email) {
		 if(auction.getOwnerEmail() != email){
	            //TODO si soy el propio owner me deberia levantar una excepcion
	            //TODO o al menos una ventana warning en frontend
			 	if (!Objects.equals(auction.getLastBidderName(), email))
			 		//get last bidder email
			 		auction.acceptBid(email);
	            
	}

}

	@Override
	public Auction createAuction(String title, String description, Float price, LocalDate start, LocalDate end, LocalTime endHour, String email) {
		  Auction newAuction = new Auction(title,description, price, start, end, endHour);
		  newAuction.setOwnerEmail(email);

		  return newAuction;
	}

	//se deberia hacer automatico, como??
	public void bidAuctionAutomaticaly(Auction auction, @NotNull String email, Float maxValue) {
		 if((!Objects.equals(auction.getLastBidderName(), email)) && (auction.getCurrentPrice()< maxValue)){
				 auction.acceptBid(email);
		 }
	            
	}

	
}
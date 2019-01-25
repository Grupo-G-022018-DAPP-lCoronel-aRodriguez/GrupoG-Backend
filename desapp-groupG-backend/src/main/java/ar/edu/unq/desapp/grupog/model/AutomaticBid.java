package ar.edu.unq.desapp.grupog.model;

import java.util.Observable;
import java.util.Observer;

public class AutomaticBid implements Observer {
	private User anUser;
	private Auction anAuction;
	private Float untilPrice;
	
	 AutomaticBid(User usr, Auction atn, Float maximum) {
		this.anAuction = atn;
		this.anUser=usr;
		this.untilPrice = maximum;
		this.anAuction.addObserver(this);
	}


	@Override
	public void update(Observable o, Object arg) {
		if (anAuction.getCurrentPrice()<untilPrice) {
			anUser.bidAuction(anAuction);
		}
		
	}

}

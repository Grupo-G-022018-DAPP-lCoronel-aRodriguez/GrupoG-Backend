package ar.edu.unq.desapp.grupoG.model;

import java.util.Observable;
import java.util.Observer;

public class AutomaticBid implements Observer {
	private User anUser;
	private Auction anAuction;
	private Float untilPrice;
	
	 AutomaticBid(User usr, Auction atn, Float maximun) {
		this.anAuction = atn;
		this.anUser=usr;
		this.untilPrice = maximun;
		this.anAuction.addObserver(this);
	}
	

	@Override
	public void update(Observable o, Object arg) {
		if (anAuction.getCurrentPrice()<untilPrice) {
			anUser.bidAuction(anAuction);
		}
		
	}

}

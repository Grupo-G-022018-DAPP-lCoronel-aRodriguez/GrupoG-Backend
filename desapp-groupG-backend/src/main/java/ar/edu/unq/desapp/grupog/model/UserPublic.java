package ar.edu.unq.desapp.grupog.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.NotNull;

public class UserPublic extends UserState {

	
	@Override
	public void bidAuction(Auction auction, @NotNull String email) {
		// TODO Auto-generated method stub
		// TODO levantar excepcion que no se puede hacer
		
	}

	@Override
	public Auction createAuction(String title, String description, Float price, LocalDate start, LocalDate end,
			LocalTime endHour, String email) {
		// TODO Auto-generated method stub
		// TODO levantar excepcion que no se puede hacer
		return null;
	}
	
	
	
}

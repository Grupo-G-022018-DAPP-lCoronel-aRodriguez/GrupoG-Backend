package ar.edu.unq.desapp.grupoG.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.NotNull;

public abstract class UserState {
	public abstract void bidAuction(Auction auction, @NotNull String email) ;
	public abstract Auction createAuction(String title, String description, Float price, LocalDate start, LocalDate end,
			LocalTime endHour, String email) ;

}

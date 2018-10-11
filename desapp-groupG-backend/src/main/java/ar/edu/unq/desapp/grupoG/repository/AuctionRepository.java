package ar.edu.unq.desapp.grupoG.repository;

import java.util.List;

import ar.edu.unq.desapp.grupoG.model.Auction;

public abstract class AuctionRepository extends GenericRepository<Auction> {
	
	abstract List<Auction> getAuctions(Integer from, int numberOfAuction, String string) ;
	
	abstract Integer getCount(String name);
	
	//abstract Set<String> getNames();
	
	abstract List<Auction> getAuction(String name);
	
	abstract List<Auction> findAll();
	

}

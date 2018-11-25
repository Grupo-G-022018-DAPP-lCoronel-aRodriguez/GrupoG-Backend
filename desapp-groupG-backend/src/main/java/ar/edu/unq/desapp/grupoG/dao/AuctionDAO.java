package ar.edu.unq.desapp.grupoG.dao;

import java.util.List;

//import javax.persistence.EntityManager;
//import javax.persistence.EntityNotFoundException;

import ar.edu.unq.desapp.grupoG.model.Auction;
import ar.edu.unq.desapp.grupoG.repository.AuctionRepositoryJPA;

public class AuctionDAO {
//	private EntityManager manager;
	private AuctionRepositoryJPA repository;

//    public AuctionDAO(EntityManager manager) {
//        this.manager = manager;
//    }

    public AuctionDAO(AuctionRepositoryJPA auctionRepository) {
		this.repository= auctionRepository;
	}

	/**
     * Find Auction based on the entity Id.
     *
     * @param auctionId the Auction Id.
     * @return Auction.
     * @throws EntityNotFoundException when no Auction is found.
     */
    public Auction findById(Long auctionId) {
//        Auction auction = manager.find(Auction.class, auctionId);
//        if (auction == null) {
//            throw new EntityNotFoundException("Can't find Auction for ID "
//                    + auctionId);
//        }
        Auction auction;
        Boolean found = false;
        int counter= 0;
        List<Auction> list= repository.findAll();
        while ((!found)&&(counter < list.size())) {
        	found = list.get(counter).getId() == auctionId;
        	counter ++;
        }
        auction = list.get(counter-1);
        return auction;
    }
}



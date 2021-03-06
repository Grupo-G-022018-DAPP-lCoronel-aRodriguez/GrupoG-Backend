package ar.edu.unq.desapp.grupog.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import ar.edu.unq.desapp.grupog.exceptions.InvalidIdException;
import ar.edu.unq.desapp.grupog.model.Auction;
import ar.edu.unq.desapp.grupog.repository.AuctionRepositoryJPA;

@Service
public class AuctionService {
	
	private AuctionRepositoryJPA auctionRepository;
	
	AuctionService(AuctionRepositoryJPA repository) {
		this.auctionRepository = repository;
	}

	public List<Auction> findAll() {
		return auctionRepository.findAll();
	}

	public Auction create(Auction auction) {
		return auctionRepository.saveAndFlush(auction);
	}

	public Optional<Auction> findById(Long id) {
		return auctionRepository.findById(id);
	}

	public Auction update(Long id, Auction modifiedAuction){
		return auctionRepository.findById(id)
				.map(auction -> {
					BeanUtils.copyProperties(modifiedAuction, auction);
					return auctionRepository.saveAndFlush(auction);
				})
				.orElseThrow(InvalidIdException::new);
	}

	public Auction delete(Long id) {
		return auctionRepository.findById(id)
				.map(auction -> {
					auctionRepository.delete(auction);
					return auction;
				})
				.orElseThrow(InvalidIdException::new);
	}

}

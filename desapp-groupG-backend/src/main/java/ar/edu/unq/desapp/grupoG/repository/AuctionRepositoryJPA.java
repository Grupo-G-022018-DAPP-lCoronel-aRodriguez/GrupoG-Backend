package ar.edu.unq.desapp.grupoG.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import ar.edu.unq.desapp.grupoG.model.Auction;

@EnableJpaRepositories 
public interface AuctionRepositoryJPA extends JpaRepository<Auction, Long>{
	Auction findById (String id);

}
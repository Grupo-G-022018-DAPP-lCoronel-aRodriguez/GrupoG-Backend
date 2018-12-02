package ar.edu.unq.desapp.grupoG.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unq.desapp.grupoG.model.Auction;

public interface AuctionRepository extends JpaRepository<Auction, Long> {
    Auction findByTitle(String title);
}

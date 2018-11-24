package ar.edu.unq.desapp.grupoG.controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
//import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.desapp.grupoG.model.Auction;
import ar.edu.unq.desapp.grupoG.repository.AuctionRepositoryJPA;

@RestController

public class AuctionController {

    @Autowired
    private AuctionRepositoryJPA auctionRepository;
	
	private static final String template = "Hello, %s!";

    @RequestMapping("/greeting")
    public Auction greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Auction(String.format(template, name),"", 0 ,LocalDate.now(),LocalDate.of(2018, 11, 20),LocalTime.now());
    }

    @RequestMapping(value="auctions", method = RequestMethod.GET)
    public List<Auction> list(){
        return auctionRepository.findAll();
    }

    @RequestMapping(value="auctions", method = RequestMethod.POST)
    public Auction create(@RequestBody Auction auction){
        return auctionRepository.saveAndFlush(auction);
    }
    
    @RequestMapping(value="auctions/{id}", method = RequestMethod.GET)
    public Auction get(@PathVariable Id id){
    	return (auctionRepository.findById(id)).get();
    }

    @RequestMapping(value="auctions/{id}", method = RequestMethod.PUT)
    public Auction update(@PathVariable Id id, @RequestBody Auction auction){
        Auction existingAuction = auctionRepository.findById(id).get();
        BeanUtils.copyProperties(auction, existingAuction);
        return auctionRepository.saveAndFlush(existingAuction);
    }

    @RequestMapping(value="auctions/{id}", method = RequestMethod.DELETE)
    public Auction delete(@PathVariable Id id){
        Auction existingAuction = auctionRepository.findById(id).get();
        auctionRepository.delete(existingAuction);
        return existingAuction;
        //returns the deleted Auction
    }

}

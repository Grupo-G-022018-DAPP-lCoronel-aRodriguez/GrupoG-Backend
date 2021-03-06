package ar.edu.unq.desapp.grupog.controllers;

import java.util.List;
import java.util.Optional;

import ar.edu.unq.desapp.grupog.services.AuctionService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.desapp.grupog.model.Auction;

@RestController

public class AuctionController {

    private AuctionService service;
    
    AuctionController(AuctionService service) {
		this.service = service;
	}
	

    @RequestMapping(value="auctions", method = RequestMethod.GET)
    public List<Auction> list(){
    	return service.findAll();
    }

    @RequestMapping(value="auctions", method = RequestMethod.POST)
    public Auction create(@RequestBody Auction auction){
    	return service.create(auction);
    }
    

    @RequestMapping(value="auctions/{id}", method = RequestMethod.GET)
    public Optional<Auction> get(@PathVariable Long id){
        return service.findById(id);
    }

    
    @RequestMapping(value="auctions/{id}", method = RequestMethod.PUT)
    public Auction update(@PathVariable Long id, @RequestBody Auction modifiedAuction){        
        return service.update(id, modifiedAuction);
    }
    
    
    @RequestMapping(value="auctions/{id}", method = RequestMethod.DELETE)
    public Auction delete(@PathVariable Long id){
        //returns the deleted Auction
    	return service.delete(id);
    }

}

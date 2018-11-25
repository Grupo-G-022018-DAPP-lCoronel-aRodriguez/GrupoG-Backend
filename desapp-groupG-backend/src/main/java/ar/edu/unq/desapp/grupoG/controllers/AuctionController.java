package ar.edu.unq.desapp.grupoG.controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.desapp.grupoG.dao.AuctionDAO;
import ar.edu.unq.desapp.grupoG.model.Auction;
import ar.edu.unq.desapp.grupoG.repository.AuctionRepositoryJPA;

@RestController

public class AuctionController {

    @Autowired
    private AuctionRepositoryJPA auctionRepository;
    private AuctionDAO auctionDAO = new AuctionDAO(auctionRepository);
	
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
    
    @RequestMapping(value="find_auction/{id}", method = RequestMethod.GET)
    public Auction get(@PathVariable Long id){
//    	return auctionDAO.findById(id);
    	return findAuctionWithId(id);
    }

    @RequestMapping(value="update_auction/{id}", method = RequestMethod.PUT)
    public Auction update(@PathVariable Long id, @RequestBody Auction auction){
        Auction existingAuction =findAuctionWithId(id);
        BeanUtils.copyProperties(auction, existingAuction);
        return auctionRepository.saveAndFlush(existingAuction);
    }

    @RequestMapping(value="delete_auction/{id}", method = RequestMethod.DELETE)
    public Auction delete(@PathVariable Long id){
        Auction existingAuction = findAuctionWithId(id);
        auctionRepository.delete(existingAuction);
        return existingAuction;
        //returns the deleted Auction
    }


    //esto deberia hacerlo otra clase, pense en auctionDAO pero no funciona
	private Auction findAuctionWithId(Long id) {
        Auction auction;
        Boolean found = false;
        int counter= 0;
        List<Auction> list= auctionRepository.findAll();
        while ((!found)&&(counter < list.size())) {
        	found = list.get(counter).getId() == id;
        	counter ++;
        }
        auction = list.get(counter-1);
        return auction;
	}
}

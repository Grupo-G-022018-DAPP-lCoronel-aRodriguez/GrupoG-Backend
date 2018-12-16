package ar.edu.unq.desapp.grupoG.model;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ar.edu.unq.desapp.grupoG.model.Auction;
import java.time.LocalDate;
import java.time.LocalTime;

public class AuctionTest {

    private Auction auction;

    @Before
    public void setUp(){
        LocalDate start = LocalDate.of(2018,9,23);
        LocalDate end = LocalDate.of(2018, 9, 27);
        LocalTime endHour = LocalTime.of(23,50,0);
        auction = new Auction("ASD","lorem ipsum", (float) 1000,start, end, endHour);
    }

    @After
    public void tearDown(){
        auction = null;
    }

    @Test
    public void testAuctionTitle(){
        assertEquals("ASD", auction.getTitle());
    }
    
    
    public void testAuctionDescription(){
        assertEquals("lorem ipsum", auction.getDescription());
    }
    
    public void testAuctionAddress(){
        assertEquals("", auction.getAddress());
    }
    
    public void testAuctionPhotoURL(){
        assertEquals("", auction.getPhotoURL());
    }
    
    public void testAuctionInitialPrice(){
        assertEquals("1000", auction.getInitialPrice());
    }
    
    public void testAuctionCurrentPrice(){
        assertEquals("", auction.getCurrentPrice());
    }
    
    public void testAuctionPublicationDate(){
        //assertEquals( "", auction.);
    }
    
    public void testAuctionUntilDate(){
        //assertEquals("", auction.);
    }
    
    public void testAuctionUntilTime(){
        //assertEquals("", auction.);
    }
    
//    public void testAuctionState(){
//        assertEquals("", auction.getAuctionState());
//    }
    
    public void testOwnerEmail(){
        assertEquals("", auction.getOwnerEmail());
    }
    
    public void testAuctionLastBidderName(){
        //assertEquals("", auction.);
    }
    
    public void testAuctionPreviousPrices(){
        //assertEquals("", auction.);
    }
        
}

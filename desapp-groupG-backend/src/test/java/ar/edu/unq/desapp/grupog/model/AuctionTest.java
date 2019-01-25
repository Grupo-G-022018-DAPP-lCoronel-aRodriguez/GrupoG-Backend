package ar.edu.unq.desapp.grupog.model;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;

public class AuctionTest {

    private Auction auction;
    private LocalDate publicationDate = LocalDate.now();
    private LocalDate start = LocalDate.of(2018,9,23);
    private LocalDate end = LocalDate.of(2018, 9, 27);
    private LocalTime endHour = LocalTime.of(23,50,0);

    @Before
    public void setUp(){
        auction = new Auction("ASD","lorem ipsum", (float) 1000, start, end, endHour);
        auction.setOwnerEmail("owner@email.com");
        auction.setLastBidderName("thelastbidder");
        auction.setAddress("theaddress");
        auction.setPhotoURL("http://photo.url.com/1");
    }

    @After
    public void tearDown(){
        auction = null;
    }

    @Test
    public void testAuctionTitle(){
        assertEquals("ASD", auction.getTitle());
    }

    @Test
    public void testAuctionDescription(){
        assertEquals("lorem ipsum", auction.getDescription());
    }

    @Test
    public void testAuctionAddress(){
        assertEquals("theaddress", auction.getAddress());
    }

    @Test
    public void testAuctionPhotoURL(){
        assertEquals("http://photo.url.com/1", auction.getPhotoURL());
    }

    @Test
    public void testAuctionInitialPrice(){
        assertEquals(1000, auction.getInitialPrice(),0);
    }

    @Test
    public void testAuctionCurrentPrice(){
        assertEquals((float)1000, auction.getCurrentPrice(), 0);
    }

    @Test
    public void testAuctionPublicationDate(){
        assertEquals( publicationDate, auction.getPublicationDate());
    }

    @Test
    public void testOwnerEmail(){
        assertEquals("owner@email.com", auction.getOwnerEmail());
    }

    @Test
    public void testAuctionLastBidderName(){
        assertEquals("thelastbidder", auction.getLastBidderName());
    }

    @Test
    public void testAuctionUntilDate(){
        assertEquals(end, auction.getUntilDate());
    }

    @Test
    public void testAuctionUntilTime(){
        assertEquals(endHour, auction.getUntilTime());
    }
    
    /*
    public void testAuctionState(){
    assertEquals("", auction.getAuctionState());
    }
    */
}

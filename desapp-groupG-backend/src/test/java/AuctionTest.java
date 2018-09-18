import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import model.Auction;

import java.time.LocalDate;
import java.time.LocalTime;

public class AuctionTest {

    private Auction auction;

    @Before
    public void setUp(){
        LocalDate start = LocalDate.of(2018,9,23);
        LocalDate end = LocalDate.of(2018, 9, 27);
        LocalTime endHour = LocalTime.of(23,50,0);
        auction = new Auction("ASD","lorem ipsum", 1000,start, end, endHour);
    }

    @After
    public void tearDown(){
        auction = null;
    }

    @Test
    public void testAuctionTitle(){
        assertEquals("ASD", auction.getTitle());
    }
}

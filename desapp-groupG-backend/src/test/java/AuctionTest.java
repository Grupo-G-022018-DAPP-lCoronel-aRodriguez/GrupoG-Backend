import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import model.Auction;

public class AuctionTest {
    private Auction auction;

    @Before
    public void setUp(){
        auction = new Auction("ASD","lorem ipsum", "avenida siempreviva 742",100);
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

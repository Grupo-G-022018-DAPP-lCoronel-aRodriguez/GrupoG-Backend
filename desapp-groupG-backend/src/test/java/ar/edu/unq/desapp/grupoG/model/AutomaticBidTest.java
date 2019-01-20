package ar.edu.unq.desapp.grupoG.model;

import ar.edu.unq.desapp.grupoG.exceptions.InvalidEmailException;
import ar.edu.unq.desapp.grupoG.exceptions.InvalidNameException;
import org.junit.Before;
import ar.edu.unq.desapp.grupoG.model.Auction;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;

public class AutomaticBidTest {

    private Auction auction;
    private User subscriber;
    private User owner;
    private User user;
    private AutomaticBid subastadorAutomatico;

    @Before
    public void setUp(){
        LocalDate start = LocalDate.of(2019, 9, 9);
        LocalDate end = LocalDate.of(2019, 9, 27);
        LocalTime endHour = LocalTime.of(23,50,0);
        float price = 100;

        auction = new Auction("Subasta", "descripcion de la subasta automatico", price,  start, end, endHour);


        subscriber = new User();
        try {
            subscriber.setEmail("suscripto@gmail.com");
        } catch (InvalidEmailException e) {
            e.printStackTrace();
        }
        try {
            subscriber.setName("Subscriptor");
        } catch (InvalidNameException e) {
            e.printStackTrace();
        }
        subscriber.setState(new UserRegistered());

        owner = new User();
        try {
            owner.setEmail("ownero@gmail.com");
        } catch (InvalidEmailException e) {
            e.printStackTrace();
        }
        try {
            owner.setName("Owner");
        } catch (InvalidNameException e) {
            e.printStackTrace();
        }
        owner.setState(new UserRegistered());
        auction.setOwnerEmail("ownero@gmail.com");

        user = new User();
        try {
            user.setEmail("user@gmail.com");
        } catch (InvalidEmailException e) {
            e.printStackTrace();
        }
        try {
            user.setName("Usuario");
        } catch (InvalidNameException e) {
            e.printStackTrace();
        }
        user.setState(new UserRegistered());

        auction.addObserver(subscriber);
        //subastadorAutomatico = new AutomaticBid(subscriber,auction,(float)1000);
    }

    @Test
    public void testSubastadorAutomatico(){
        //esta como automatico
        //subasta el otro user
        float currentPrice = auction.getCurrentPrice();
        user.bidAuction(auction);
        //automatic bid
        assert (currentPrice < auction.getCurrentPrice());
        //System.out.print(auction.getCurrentPrice());
        auction.printHistory();
        //el precio cambio
    }

}

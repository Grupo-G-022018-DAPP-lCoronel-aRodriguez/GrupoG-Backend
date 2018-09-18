package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class RegisteredUser extends User{
    // ver subasta
    // busqueda
    // crear, modificar, eliminar subasta (owner)
    // ofertar(no owner)

    public Auction createAuction(String title, String description, Integer price, LocalDate start, LocalDate end, LocalTime endHour){

        Auction newAuction = new Auction(title,description, price, start, end, endHour);
        newAuction.setOwnerEmail(this.getEmail());

        return newAuction;
    }

    public void bidAuction(Auction auction){
        if(auction.getOwnerEmail() != this.getEmail()){
            //TODO si soy el propio owner me deberia levantar una excepcion
            //TODO o al menos una ventana warning en frontend
            auction.acceptBid();
        }
    }
}

package ar.edu.unq.desapp.grupoG.controllers;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.desapp.grupoG.model.Auction;

@RestController

public class AuctionController {
	
	private static final String template = "Hello, %s!";

    @RequestMapping("/greeting")
    public Auction greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Auction(String.format(template, name),"", 0 ,LocalDate.now(),LocalDate.of(2018, 11, 20),LocalTime.now());
    }


}

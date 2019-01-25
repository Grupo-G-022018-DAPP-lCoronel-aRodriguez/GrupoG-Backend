package ar.edu.unq.desapp.grupog.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "/h2";
    }

}

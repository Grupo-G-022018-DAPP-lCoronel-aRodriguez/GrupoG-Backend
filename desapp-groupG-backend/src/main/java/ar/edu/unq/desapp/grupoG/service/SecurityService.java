package ar.edu.unq.desapp.grupoG.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);


}

package ar.edu.unq.desapp.grupoG.validator;

import java.time.LocalDate;

public class Validator {

    //User validations

    public static boolean isValidName(String name) {
        return name.length() >= 1 && name.length() < 30;
    }

    public static boolean isValidSurname(String surname) {
        return isValidName(surname);
    }

    public static boolean isValidEmail(String email) {
        //TODO better validation (e.g .com.ar)
        return email.contains("@") && email.endsWith(".com");
    }

    public static boolean isValidPassword(String password) {
        //TODO check password contains only alphanumeric characters
        return password.length() >= 4 && password.length() < 30;
    }

    public static boolean isValidDate(LocalDate birth) {
        //return birth.after(Date(1,1,1990);
        //TODO validar la fecha, tiene que ser antes de hoy y despues de 1900
        //TODO validar formato DD/MM/YYYY, validar +18
        return true;
    }

    //Auction validations

    public static boolean isValidTitle(String title){
        return title.length() > 10 && title.length() < 50;
    }

    public static boolean isValidDescription(String description){
        return description.length() > 10 && description.length() < 100;
    }

    public static boolean isValidPublicationDate(LocalDate start){
        return start.isAfter(LocalDate.now());
    }

    public static boolean isValidUntilDate(LocalDate start, LocalDate end){
        return end.compareTo(start) >= 2;
    }

}

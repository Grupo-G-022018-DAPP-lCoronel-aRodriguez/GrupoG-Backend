package model;

import java.time.LocalDate;

public class Validator {

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

}

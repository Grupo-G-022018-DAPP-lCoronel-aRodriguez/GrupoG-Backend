package ar.edu.unq.desapp.grupoG.model;

import org.junit.Test;

import ar.edu.unq.desapp.grupoG.validator.Validator;

import java.time.LocalDate;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class ValidatorTest {

    @Test
    public void testIsValidName() {
        assertTrue(Validator.isValidName("name"));
    }

    @Test
    public void testIsValidName1Character() {
        assertTrue(Validator.isValidName("a"));
    }

    @Test
    public void testIsValidNameShouldFailMoreThan30Characters(){
        assertFalse(Validator.isValidName("abcdefghijklmnopqrstuvwxyzabcd"));
    }

    @Test
    public void testIsValidSurname(){
        assertTrue(Validator.isValidSurname("surname"));
    }

    @Test
    public void testIsValidSurname1Character(){
        assertTrue(Validator.isValidSurname("s"));
    }

    @Test
    public void testIsValidSurnameShouldFailIfMoreThan30Characters(){
        assertFalse(Validator.isValidSurname("abcdefghijklmnopqrstuvwxyzabcd"));
    }

    @Test
    public void testIsValidEmail(){
        assertTrue(Validator.isValidEmail("asd@email.com"));
    }

    @Test
    public void testIsValidEmailShouldFailNoAt(){
        assertFalse(Validator.isValidEmail("asdemail.com"));
    }

    @Test
    public void testIsValidEmailShouldFailNotFinishesInDotCom(){
        assertFalse(Validator.isValidEmail("asd@email"));
    }

    @Test
    public void testIsValidPassword4Characters(){
        assertTrue(Validator.isValidPassword("casa"));
    }

    @Test
    public void testIsValidPasswordShouldFail3Characters(){
        assertFalse(Validator.isValidPassword("lol"));
    }

    @Test
    public void testIsValidPasswordShouldFail30Characters(){
        assertFalse(Validator.isValidPassword("abcdefghijklmnopqrstuvwxyzabcd"));
    }

    // Auction

    @Test
    public void testIsValidTitle(){
        assertTrue(Validator.isValidTitle("Titulo Valido"));
    }

    @Test
    public void testIsValidTitleShouldFailLessThan10Characters(){
        assertFalse(Validator.isValidTitle("Titulo"));
    }

    @Test
    public void testIsValidDescription(){
        assertTrue(Validator.isValidDescription("Descripcion Valido"));
    }

    @Test
    public void testIsValidDescriptionShouldFailLessThan10Characters(){
        assertFalse(Validator.isValidDescription("Desc"));
    }

    @Test
    public void testIsValidPublicationDate(){
        LocalDate hoy = LocalDate.now();
        LocalDate ejemplo = hoy.plusDays(3);
        assertTrue(Validator.isValidPublicationDate(ejemplo));
    }

    @Test
    public void testIsValidPublicationDateShouldFail(){
        LocalDate hoy = LocalDate.now();
        assertFalse(Validator.isValidPublicationDate(hoy));
    }

    @Test
    public void testIsValidUntilDate(){
        LocalDate hoy = LocalDate.now();
        LocalDate ejemplo = hoy.plusDays(2);
        assertTrue(Validator.isValidUntilDate(hoy,ejemplo));
    }

    @Test
    public void testIsValidUntilDateShouldFailLessThanTwoDays(){
        LocalDate hoy = LocalDate.now();
        LocalDate ejemplo = hoy.plusDays(1);
        assertFalse(Validator.isValidUntilDate(hoy,ejemplo));
    }


}

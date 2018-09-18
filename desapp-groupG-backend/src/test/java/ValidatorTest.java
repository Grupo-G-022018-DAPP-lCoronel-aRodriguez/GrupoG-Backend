
import model.Validator;
import org.junit.Test;

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
}

import static org.junit.Assert.*;

import exceptions.InvalidEmailException;
import exceptions.InvalidNameException;
import exceptions.InvalidPasswordException;
import exceptions.InvalidSurnameException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import model.User;

public class UserTest {

    private User user;

    @Before
    public void setUp() {
        user = new User();
    }

    @After
    public void tearDown() {
        user = null;
    }

    @Test
    public void testSetUserName() throws InvalidNameException {
        user.setName("a");
        assertEquals("a", user.getName());
    }

    @Test(expected = InvalidNameException.class)
    public void testSetUserNameShouldFailIfMoreThan30Characters() throws InvalidNameException {
        user.setName("abcdefghijklmnopqrstuvwxyzabcd");
        assertEquals("abcdefghijklmnopqrstuvwxyz", user.getName());
    }


    @Test
    public void testSetSurname() throws InvalidSurnameException {
        user.setSurname("surname");
        assertEquals("surname", user.getSurname());
    }

    @Test(expected = InvalidSurnameException.class)
    public void testSetSurameShouldFailIfMoreThan30Characters() throws InvalidSurnameException {
        user.setSurname("abcdefghijklmnopqrstuvwxyzabcd");
        assertEquals("abcdefghijklmnopqrstuvwxyzabcd", user.getSurname());
    }

    @Test
    public void testSetValidEmail() throws InvalidEmailException {
        user.setEmail("asd@gmail.com");
        assertEquals("asd@gmail.com",user.getEmail());
    }

    @Test(expected = InvalidEmailException.class)
    public void testSetInvalidEmail() throws InvalidEmailException {
        user.setEmail("asdgmail.com");
        assertEquals("asdgmail.com",user.getEmail());
    }

    @Test
    public void testSetValidPassword() throws InvalidPasswordException {
        user.setPassword("casa");
        assertEquals("casa",user.getPassword());
    }

    @Test(expected = InvalidPasswordException.class)
    public void testSetInvalidPasswordShort() throws InvalidPasswordException {
        user.setPassword("lol");
        assertEquals("lol",user.getPassword());
    }

    @Test(expected = InvalidPasswordException.class)
    public void testSetInvalidPasswordLong() throws InvalidPasswordException {
        user.setPassword("abcdefghijklmnopqrstuvwxyzabcd");
        assertEquals("abcdefghijklmnopqrstuvwxyzabcd",user.getPassword());
    }

}

import static org.junit.Assert.*;

import exceptions.InvalidEmailException;
import exceptions.InvalidNameException;
import exceptions.InvalidPasswordException;
import exceptions.InvalidSurnameException;
import model.Auction;
import model.RegisteredUser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import model.User;

import java.time.LocalDate;
import java.time.LocalTime;

public class UserTest {

    private User user;
    private RegisteredUser anotherUser;
    private RegisteredUser regUser;

    @Before
    public void setUp() throws InvalidEmailException {
        user = new User();
        user.setEmail("usuario@dominio.com");

        regUser = new RegisteredUser();
        regUser.setEmail("registrado@hotmail.com");

        anotherUser = new RegisteredUser();
        anotherUser.setEmail("otro@gmail.com");
    }

    @After
    public void tearDown() {
        user = null;
        anotherUser = null;
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

    //test Methods

    @Test
    public void testCreateAuction(){
        LocalDate start = LocalDate.of(2018,9,23);
        LocalDate end = LocalDate.of(2018, 9, 27);
        LocalTime endHour = LocalTime.of(23,50,0);

        Auction auction = regUser.createAuction("ejemplo","descripcion", 20, start, end, endHour);

        assertNotNull(auction);

        assertEquals("ejemplo", auction.getTitle());
        assertEquals("descripcion", auction.getDescription());
        assertEquals(20, (long)auction.getInitialPrice());

        assertEquals("registrado@hotmail.com", auction.getOwnerEmail());

    }

    @Test
    public void testBidAuctionShouldFailIfOwnerBids(){
        LocalDate start = LocalDate.of(2018,9,23);
        LocalDate end = LocalDate.of(2018, 9, 27);
        LocalTime endHour = LocalTime.of(23,50,0);

        Auction auction = regUser.createAuction("ejemplo","descripcion", 20, start, end, endHour);

        regUser.bidAuction(auction);
        //el precio no cambia porque soy el mismo dueño, no
        //puedo ofertar
        assertEquals(20, (long)auction.getCurrentPrice());
    }

    @Test
    public void testBidAuction(){
        LocalDate start = LocalDate.of(2018,9,23);
        LocalDate end = LocalDate.of(2018, 9, 27);
        LocalTime endHour = LocalTime.of(23,50,0);

        Auction auction = regUser.createAuction("ejemplo","descripcion", 20, start, end, endHour);

        anotherUser.bidAuction(auction);
        //el precio cambia
        assertEquals(30, (long)auction.getCurrentPrice());
    }

}

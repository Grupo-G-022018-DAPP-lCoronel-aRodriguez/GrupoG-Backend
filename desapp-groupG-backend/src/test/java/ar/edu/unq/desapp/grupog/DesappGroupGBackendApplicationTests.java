package ar.edu.unq.desapp.grupog;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class DesappGroupGBackendApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void auctionsTest() {
		String body = this.restTemplate.getForObject("/auctions", String.class);
		assert("[]".equals(body));
	}

	@Test
	public void usersTest(){
		String body = this.restTemplate.getForObject("/users", String.class);
		assert("[]".equals(body));
	}

}

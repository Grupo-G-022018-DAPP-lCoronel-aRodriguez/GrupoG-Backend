package ar.edu.unq.desapp.grupog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class DesappGroupGBackendApplication extends SpringBootServletInitializer{
	/*Extending the SpringBootServletInitializer class also allows us to configure our application 
	 * when it’s run by the servlet container, by overriding the configure() method.*/
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DesappGroupGBackendApplication.class);
    }


	public static void main(String[] args) throws Exception {
		SpringApplication.run(DesappGroupGBackendApplication.class, args);
	}
}
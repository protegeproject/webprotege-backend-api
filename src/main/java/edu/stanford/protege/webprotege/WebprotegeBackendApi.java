package edu.stanford.protege.webprotege;

import edu.stanford.protege.webprotege.jackson.WebProtegeJacksonApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({WebProtegeJacksonApplication.class})
public class WebprotegeBackendApi {

	public static void main(String[] args) {
		SpringApplication.run(WebprotegeBackendApi.class, args);
	}
}

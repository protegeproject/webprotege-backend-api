package edu.stanford.protege.webprotege;

import edu.stanford.protege.webprotege.jackson.WebProtegeJacksonApplication;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import uk.ac.manchester.cs.owl.owlapi.OWLDataFactoryImpl;

@Configuration
@Import({WebProtegeJacksonApplication.class})
public class WebprotegeBackendApi {

	public static void main(String[] args) {
		SpringApplication.run(WebprotegeBackendApi.class, args);
	}
}

package edu.stanford.protege.webprotege;

import org.semanticweb.owlapi.model.OWLDataFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import uk.ac.manchester.cs.owl.owlapi.OWLDataFactoryImpl;

@SpringBootApplication
public class WebprotegeBackendMonolithApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebprotegeBackendMonolithApplication.class, args);
	}

	@Bean
	public OWLDataFactory dataFactory() {
		return new OWLDataFactoryImpl();
	}

}

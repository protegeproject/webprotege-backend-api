package edu.stanford.protege.webprotege;

import org.semanticweb.owlapi.model.OWLDataFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import uk.ac.manchester.cs.owl.owlapi.OWLDataFactoryImpl;

@SpringBootApplication
public class WebprotegeBackendApi {

	public static void main(String[] args) {
		SpringApplication.run(WebprotegeBackendApi.class, args);
	}
}

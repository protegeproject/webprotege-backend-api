package edu.stanford.protege.webprotege.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 18 Jun 2018
 */
@JsonComponent
public class OWLClassDeserializer extends StdDeserializer<OWLClass> {

    private final OWLEntityDeserializer<OWLClass> deserializer;

    public OWLClassDeserializer(OWLDataFactory dataFactory) {
        super(OWLClass.class);
        deserializer = new OWLEntityDeserializer<>(dataFactory, OWLClass.class);
    }

    @Override
    public OWLClass deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return deserializer.deserialize(jsonParser, deserializationContext);
    }
}

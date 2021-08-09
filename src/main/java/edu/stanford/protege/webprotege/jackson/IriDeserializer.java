package edu.stanford.protege.webprotege.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.semanticweb.owlapi.model.IRI;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 18 Jun 2018
 */
@JsonComponent
public class IriDeserializer extends StdDeserializer<IRI> {

    public IriDeserializer() {
        super(IRI.class);
    }

    @Override
    public IRI deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return IRI.create(jsonParser.getValueAsString());
    }
}


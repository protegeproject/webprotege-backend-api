package edu.stanford.protege.webprotege.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.semanticweb.owlapi.model.AxiomType;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-08
 */
@JsonComponent
public class AxiomTypeDeserializer extends StdDeserializer<AxiomType> {

    public AxiomTypeDeserializer() {
        super(AxiomType.class);
    }

    @Override
    public AxiomType deserialize(JsonParser p,
                                 DeserializationContext ctxt) throws IOException {
        String v = p.getValueAsString();
        return AxiomType.getAxiomType(v);
    }
}

package edu.stanford.protege.webprotege.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntologyID;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-06
 */
@JsonComponent
public class OWLOntologyIDDeserializer extends StdDeserializer<OWLOntologyID> {

    public OWLOntologyIDDeserializer() {
        super(OWLOntologyID.class);
    }

    @Override
    public OWLOntologyID deserialize(JsonParser jsonParser,
                                     DeserializationContext ctxt) throws IOException {
        String ontologyIri = null;
        String versionIri = null;
        while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
            String fieldname = jsonParser.getCurrentName();
            if ("ontologyIri".equals(fieldname)) {
                jsonParser.nextToken();
                ontologyIri = jsonParser.readValueAs(String.class);
            }
            else if("versionIri".equals(fieldname)) {
                jsonParser.nextToken();
                versionIri = jsonParser.readValueAs(String.class);
            }
        }
        if(ontologyIri != null) {
            if(versionIri != null) {
                return new OWLOntologyID(IRI.create(ontologyIri), IRI.create(versionIri));
            }
            else {
                return new OWLOntologyID(IRI.create(ontologyIri));
            }
        }
        else {
            return new OWLOntologyID();
        }
    }
}

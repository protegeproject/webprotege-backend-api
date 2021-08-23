package edu.stanford.protege.webprotege.merge_add;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.dispatch.Result;
import org.semanticweb.owlapi.model.OWLOntologyID;

import java.util.List;



@JsonTypeName("GetAllOntologies")
public record GetUploadedOntologiesResult(@JsonProperty("ontologies") List<OWLOntologyID> ontologies) implements Result {

}

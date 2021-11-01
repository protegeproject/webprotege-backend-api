package edu.stanford.protege.webprotege.ontology;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.dispatch.Result;
import org.semanticweb.owlapi.model.OWLAnnotation;

import java.util.Set;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 01/08/2013
 */


@JsonTypeName("webprotege.ontologies.SetOntologyAnnotations")
public record SetOntologyAnnotationsResult(@JsonProperty("ontologyAnnotations") Set<OWLAnnotation> ontologyAnnotations) implements Result {

}

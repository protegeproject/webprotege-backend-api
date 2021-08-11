package edu.stanford.protege.webprotege.ontology;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.dispatch.Result;
import edu.stanford.protege.webprotege.frame.PropertyAnnotationValue;
import org.semanticweb.owlapi.model.OWLOntologyID;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 28 Jul 16
 */


@JsonTypeName("GetOntologyAnnotations")
public record GetOntologyAnnotationsResult(@JsonProperty("ontologyId") OWLOntologyID ontologyID,
                                           @JsonProperty("annotations") ImmutableList<PropertyAnnotationValue> annotations) implements Result {
}

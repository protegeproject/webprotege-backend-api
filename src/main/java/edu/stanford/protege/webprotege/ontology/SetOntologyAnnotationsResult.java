package edu.stanford.protege.webprotege.ontology;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.auto.value.AutoValue;
import edu.stanford.protege.webprotege.dispatch.Result;
import edu.stanford.protege.webprotege.event.EventList;
import edu.stanford.protege.webprotege.event.HasEventList;
import edu.stanford.protege.webprotege.event.ProjectEvent;
import org.semanticweb.owlapi.model.OWLAnnotation;

import java.util.Set;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 01/08/2013
 */
@AutoValue

@JsonTypeName("SetOntologyAnnotations")
public abstract class SetOntologyAnnotationsResult implements Result, HasEventList<ProjectEvent> {

    @JsonCreator
    public static SetOntologyAnnotationsResult create(@JsonProperty("ontologyAnnotations") Set<OWLAnnotation> ontologyAnnotations,
                                                      @JsonProperty("eventList") EventList<ProjectEvent> eventList) {
        return new AutoValue_SetOntologyAnnotationsResult(ontologyAnnotations, eventList);
    }

    public abstract Set<OWLAnnotation> getOntologyAnnotations();

    @Override
    public abstract EventList<ProjectEvent> getEventList();
}

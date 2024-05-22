package edu.stanford.protege.webprotege.event;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.EventId;
import edu.stanford.protege.webprotege.common.ProjectEvent;
import edu.stanford.protege.webprotege.common.ProjectId;
import org.semanticweb.owlapi.model.OWLOntologyID;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 18/12/2012
 *
 * Constructs an OntologyBrowserTextChangedEvent.
 * @param ontologyID The id of the ontology whose browser text has changed.  Not {@code null}.
 * @param oldValue The old browser text.  Not {@code null}.  May be empty.
 * @param newValue The new browser text.  Not {@code null}.  May be empty.
 */

@JsonTypeName("webprotege.events.ontologies.OntologyBrowserTextChanged")
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "type")
public record OntologyBrowserTextChangedEvent(EventId eventId,
                                              ProjectId projectId,
                                              OWLOntologyID ontologyID,
                                              String oldValue,
                                              String newValue) implements ProjectEvent {

    public static final String CHANNEL = "webprotege.events.ontologies.OntologyBrowserTextChanged";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

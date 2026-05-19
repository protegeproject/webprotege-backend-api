package edu.stanford.protege.webprotege.event;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.EventId;
import edu.stanford.protege.webprotege.common.ProjectEvent;
import edu.stanford.protege.webprotege.common.ProjectId;
import org.semanticweb.owlapi.model.OWLEntity;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 21/03/2013
 */
@JsonTypeName("webprotege.events.entities.EntityDeprecationStatusChanged")
public record EntityDeprecationStatusChangedEvent(@JsonProperty("eventId") EventId eventId,
                                                  @JsonProperty("projectId") ProjectId projectId,
                                                  @JsonProperty("entity") OWLEntity entity,
                                                  @JsonProperty("deprecated") boolean deprecated) implements ProjectEvent {

    public static final String CHANNEL = "webprotege.events.entities.EntityDeprecationStatusChanged";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

package edu.stanford.protege.webprotege.event;


import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.Event;
import edu.stanford.protege.webprotege.common.ProjectId;
import org.semanticweb.owlapi.model.OWLEntity;

import java.util.Objects;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 21/03/2013
 */
@JsonTypeName("EntityDeprecationStatusChangedEvent")
public record EntityDeprecationStatusChangedEvent(ProjectId source, OWLEntity entity, boolean deprecated) implements Event {

    public static final String CHANNEL = "webprotege.entities.events.EntityDeprecationStatusChanged";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

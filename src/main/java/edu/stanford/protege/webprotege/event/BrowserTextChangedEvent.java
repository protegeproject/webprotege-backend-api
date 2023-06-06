package edu.stanford.protege.webprotege.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.common.EventId;
import edu.stanford.protege.webprotege.common.ProjectEvent;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.ShortForm;
import org.semanticweb.owlapi.model.OWLEntity;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 19/03/2013
 */
@JsonTypeName("webprotege.events.entities.BrowserTextChanged")
public record BrowserTextChangedEvent(@JsonProperty("eventId") EventId eventId,
                                      @JsonProperty("projectId") ProjectId projectId,
                                      @JsonProperty("entity") OWLEntity entity,
                                      @JsonProperty("newBrowserText") String newBrowserText,
                                      @JsonProperty("shortForms") ImmutableList<ShortForm> shortForms) implements ProjectEvent {

    public static final String CHANNEL = "webprotege.events.entities.BrowserTextChanged";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

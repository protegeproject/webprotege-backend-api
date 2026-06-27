package edu.stanford.protege.webprotege.event;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.EventId;
import edu.stanford.protege.webprotege.common.ProjectEvent;
import edu.stanford.protege.webprotege.common.ProjectId;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2020-11-04
 */
@JsonTypeName("webprotege.events.projects.LargeNumberOfChanges")
public record LargeNumberOfChangesEvent(@JsonProperty("eventId") EventId eventId,
                                        @JsonProperty("projectId") ProjectId projectId) implements ProjectEvent {

    public static final String CHANNEL = "webprotege.events.projects.LargeNumberOfChanges";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

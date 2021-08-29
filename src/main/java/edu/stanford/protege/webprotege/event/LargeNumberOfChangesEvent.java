package edu.stanford.protege.webprotege.event;



import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.Event;
import edu.stanford.protege.webprotege.common.ProjectEvent;
import edu.stanford.protege.webprotege.common.ProjectId;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2020-11-04
 */
@JsonTypeName("LargeNumberOfChangesEvent")
public record LargeNumberOfChangesEvent(ProjectId projectId) implements ProjectEvent {

    public static final String CHANNEL = "webprotege.projects.events.LargeNumberOfChanges";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

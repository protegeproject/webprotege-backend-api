package edu.stanford.protege.webprotege.watches;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.EventId;
import edu.stanford.protege.webprotege.common.ProjectEvent;
import edu.stanford.protege.webprotege.common.ProjectId;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 21/03/2013
 */
@JsonTypeName("webprotege.events.watches.WatchRemoved")
public record WatchRemovedEvent(EventId eventId,
                                ProjectId projectId,
                                Watch watch) implements ProjectEvent {

    public static final String CHANNEL = "webprotege.events.watches.WatchRemoved";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

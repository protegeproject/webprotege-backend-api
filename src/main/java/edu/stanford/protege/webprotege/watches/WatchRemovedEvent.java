package edu.stanford.protege.webprotege.watches;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.Event;
import edu.stanford.protege.webprotege.common.ProjectEvent;
import edu.stanford.protege.webprotege.common.ProjectId;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 21/03/2013
 */
@JsonTypeName("webprotege.watches.events.WatchRemoved")
public record WatchRemovedEvent(ProjectId projectId, Watch watch) implements ProjectEvent {

    public static final String CHANNEL = "webprotege.watches.events.WatchRemoved";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

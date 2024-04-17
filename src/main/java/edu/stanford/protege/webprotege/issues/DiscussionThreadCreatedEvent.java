package edu.stanford.protege.webprotege.issues;


import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.EventId;
import edu.stanford.protege.webprotege.common.ProjectEvent;
import edu.stanford.protege.webprotege.common.ProjectId;

import static edu.stanford.protege.webprotege.issues.DiscussionThreadCreatedEvent.*;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 12 Oct 2016
 */
@JsonTypeName(CHANNEL)
public record DiscussionThreadCreatedEvent(EventId eventId,
                                           ProjectId projectId,
                                           EntityDiscussionThread discussionThread) implements ProjectEvent {

    public static final String CHANNEL = "webprotege.events.discussions.DiscussionThreadCreated";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

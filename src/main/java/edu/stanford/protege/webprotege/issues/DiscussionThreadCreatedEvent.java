package edu.stanford.protege.webprotege.issues;



import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.Event;
import edu.stanford.protege.webprotege.common.ProjectId;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 12 Oct 2016
 */
@JsonTypeName("DiscussionThreadCreatedEvent")
public record DiscussionThreadCreatedEvent(ProjectId projectId,
                                          EntityDiscussionThread discussionThread) implements Event {

    public static final String CHANNEL = "webprotege.discussion.events.DiscussionThreadCreated";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

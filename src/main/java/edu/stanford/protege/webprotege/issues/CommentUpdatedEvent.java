package edu.stanford.protege.webprotege.issues;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.EventId;
import edu.stanford.protege.webprotege.common.ProjectEvent;
import edu.stanford.protege.webprotege.common.ProjectId;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 11 Oct 2016
 */
@JsonTypeName("webprotege.events.discussions.CommentUpdated")
public record CommentUpdatedEvent(@JsonProperty("eventId") @Nonnull EventId eventId,
                                  @JsonProperty("projectId") @Nonnull ProjectId projectId,
                                  @JsonProperty("threadId") @Nonnull ThreadId threadId,
                                  @JsonProperty("comment") @Nonnull Comment comment) implements ProjectEvent {

    public static final String CHANNEL = "webprotege.events.discussions.CommentUpdated";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

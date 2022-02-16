package edu.stanford.protege.webprotege.issues;


import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.Event;
import edu.stanford.protege.webprotege.common.EventId;
import edu.stanford.protege.webprotege.common.ProjectEvent;
import edu.stanford.protege.webprotege.common.ProjectId;

import javax.annotation.Nonnull;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 11 Oct 2016
 */
@JsonTypeName("webprotege.events.discussions.CommentUpdated")
public record CommentUpdatedEvent(@Nonnull EventId eventId,
                                  @Nonnull ProjectId projectId,
                                  @Nonnull ThreadId threadId,
                                  @Nonnull Comment comment) implements ProjectEvent {

    public static final String CHANNEL = "webprotege.events.discussions.CommentUpdated";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

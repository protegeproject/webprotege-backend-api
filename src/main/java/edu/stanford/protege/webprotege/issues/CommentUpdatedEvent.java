package edu.stanford.protege.webprotege.issues;


import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.Event;
import edu.stanford.protege.webprotege.common.ProjectId;

import javax.annotation.Nonnull;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 11 Oct 2016
 */
@JsonTypeName("CommentUpdatedEvent")
public record CommentUpdatedEvent(@Nonnull ProjectId projectId,
                                 @Nonnull ThreadId threadId,
                                 @Nonnull Comment comment) implements Event {

    public static final String CHANNEL = "webprotege.discussions.events.CommentUpdated";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

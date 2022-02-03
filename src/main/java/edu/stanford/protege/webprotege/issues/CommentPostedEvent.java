package edu.stanford.protege.webprotege.issues;


import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.Event;
import edu.stanford.protege.webprotege.common.ProjectEvent;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.entity.OWLEntityData;

import javax.annotation.Nonnull;
import java.util.Optional;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 11 Oct 2016
 */
@JsonTypeName("webprotege.events.discussion.CommentPosted")
public record CommentPostedEvent(@Nonnull ProjectId projectId,
                                 @Nonnull ThreadId threadId,
                                 @Nonnull Comment comment,
                                 @Nonnull Optional<OWLEntityData> entity,
                                 int commentCountForEntity,
                                 int openCommentCountForEntity) implements ProjectEvent {

    public static final String CHANNEL = "webprotege.events.discussion.CommentPosted";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

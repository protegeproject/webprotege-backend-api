package edu.stanford.protege.webprotege.issues;


import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import edu.stanford.protege.webprotege.common.ProjectId;

import javax.annotation.Nonnull;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 12 Oct 2016
 */
public record SetDiscussionThreadStatusAction(@Nonnull ProjectId projectId,
                                             @Nonnull ThreadId threadId,
                                             @Nonnull Status status) implements ProjectAction<SetDiscussionThreadStatusResult> {

}

package edu.stanford.protege.webprotege.issues;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import org.semanticweb.owlapi.model.OWLEntity;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 5 Oct 2016
 */
@JsonTypeName("webprotege.discussions.GetEntityDiscussionThreads")
public record GetEntityDiscussionThreadsAction(@Nonnull ProjectId projectId, @Nonnull OWLEntity entity) implements ProjectAction<GetEntityDiscussionThreadsResult> {

    public static final String CHANNEL = "webprotege.discussions.GetEntityDiscussionThreads";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

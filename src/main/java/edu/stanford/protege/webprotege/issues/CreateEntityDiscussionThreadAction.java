package edu.stanford.protege.webprotege.issues;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import org.semanticweb.owlapi.model.OWLEntity;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 6 Oct 2016
 */
@JsonTypeName("CreateEntityDiscussionThread")
public record CreateEntityDiscussionThreadAction(ProjectId projectId,
                                                         OWLEntity entity,
                                                         String comment) implements ProjectAction<CreateEntityDiscussionThreadResult> {

    public static final String CHANNEL = "webprotege.discussions.CreateEntityDiscussionThread";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

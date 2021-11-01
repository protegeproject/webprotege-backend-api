package edu.stanford.protege.webprotege.issues;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import edu.stanford.protege.webprotege.project.HasProjectId;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 7 Oct 2016
 */
@JsonTypeName("webprotege.discussions.AddComment")
public record AddCommentAction(ProjectId projectId,
                               ThreadId threadId,
                               String comment) implements ProjectAction<AddCommentResult>, HasProjectId {

    public static final String CHANNEL = "webprotege.discussions.AddComment";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

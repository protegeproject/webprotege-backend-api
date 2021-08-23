package edu.stanford.protege.webprotege.issues;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 9 Oct 2016
 */
@JsonTypeName("DeleteComment")
public record DeleteCommentAction(ProjectId projectId,
                                  CommentId commentId) implements ProjectAction<DeleteCommentResult> {

    public static final String CHANNEL = "webprotege.discussions.DeleteComment";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

package edu.stanford.protege.webprotege.issues;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ChangeRequestId;
import edu.stanford.protege.webprotege.common.ContentChangeRequest;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 9 Oct 2016
 */
@JsonTypeName("webprotege.discussions.DeleteComment")
public record DeleteCommentAction(ChangeRequestId changeRequestId,
                                  ProjectId projectId,
                                  CommentId commentId) implements ProjectAction<DeleteCommentResult>, ContentChangeRequest {

    public static final String CHANNEL = "webprotege.discussions.DeleteComment";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

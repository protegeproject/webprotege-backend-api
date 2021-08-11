package edu.stanford.protege.webprotege.issues;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 9 Oct 2016
 */
@JsonTypeName("DeleteEntityComment")
public record DeleteEntityCommentAction(ProjectId projectId,
                                        CommentId commentId) implements ProjectAction<DeleteEntityCommentResult> {
}

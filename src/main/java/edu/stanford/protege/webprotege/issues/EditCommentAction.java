package edu.stanford.protege.webprotege.issues;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.auto.value.AutoValue;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import edu.stanford.protege.webprotege.common.ProjectId;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 8 Oct 2016
 */


@JsonTypeName("EditComment")
public record EditCommentAction(@JsonProperty("projectId") @Nonnull ProjectId projectId,
                                @JsonProperty("threadId") @Nonnull ThreadId threadId,
                                @JsonProperty("commentId") @Nonnull CommentId commentId,
                                @JsonProperty("body") @Nonnull String body) implements ProjectAction<EditCommentResult> {
}

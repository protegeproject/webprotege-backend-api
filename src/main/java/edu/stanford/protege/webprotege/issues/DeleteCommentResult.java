package edu.stanford.protege.webprotege.issues;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.dispatch.Result;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 9 Oct 2016
 */


@JsonTypeName("DeleteEntityComment")
public record DeleteCommentResult(@JsonProperty("commentId") @Nonnull CommentId commentId,
                                  @JsonProperty("deleted") boolean deleted) implements Result {
}

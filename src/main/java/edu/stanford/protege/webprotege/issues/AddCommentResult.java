package edu.stanford.protege.webprotege.issues;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.Result;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 7 Oct 2016
 */


@JsonTypeName("AddEntityComment")
public record AddCommentResult(@JsonProperty("projectId") ProjectId newProjectId,
                               @JsonProperty("threadId") ThreadId newThreadId,
                               @JsonProperty("comment") Comment newComment,
                               @JsonProperty("commentRendering") String newCommentRendering) implements Result {
}

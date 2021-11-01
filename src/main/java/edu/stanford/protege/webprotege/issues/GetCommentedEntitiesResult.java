package edu.stanford.protege.webprotege.issues;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.Result;
import edu.stanford.protege.webprotege.entity.CommentedEntityData;
import edu.stanford.protege.webprotege.common.Page;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 7 Mar 2017
 */


@JsonTypeName("webprotege.discussions.GetCommentedEntities")
public record GetCommentedEntitiesResult(@JsonProperty("projectId") ProjectId projectId,
                                         @JsonProperty("entities") Page<CommentedEntityData> entities) implements Result {
}

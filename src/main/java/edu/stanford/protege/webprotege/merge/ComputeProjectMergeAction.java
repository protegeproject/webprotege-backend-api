package edu.stanford.protege.webprotege.merge;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.auto.value.AutoValue;
import edu.stanford.protege.webprotege.csv.DocumentId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import edu.stanford.protege.webprotege.common.ProjectId;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 26/01/15
 */


@JsonTypeName("ComputeProjectMerge")
public record ComputeProjectMergeAction(@JsonProperty("projectId") ProjectId projectId,
                                        @JsonProperty("projectDocumentId") DocumentId projectDocumentId) implements ProjectAction<ComputeProjectMergeResult> {

}


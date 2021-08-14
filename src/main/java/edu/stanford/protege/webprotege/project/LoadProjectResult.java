package edu.stanford.protege.webprotege.project;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.Result;
import edu.stanford.protege.webprotege.common.UserId;

import javax.annotation.Nonnull;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 05/04/2013
 */


@JsonTypeName("LoadProject")
public record LoadProjectResult(@JsonProperty("projectId") @Nonnull ProjectId projectId,
                                @JsonProperty("userId") @Nonnull UserId loadedBy,
                                @JsonProperty("projectDetails") @Nonnull ProjectDetails projectDetails) implements Result {
}

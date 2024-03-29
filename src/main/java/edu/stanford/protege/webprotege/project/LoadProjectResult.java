package edu.stanford.protege.webprotege.project;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.UserId;
import edu.stanford.protege.webprotege.dispatch.Result;

import javax.annotation.Nonnull;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 05/04/2013
 */


@JsonTypeName("webprotege.projects.LoadProject")
public record LoadProjectResult(@JsonProperty("projectId") @Nonnull ProjectId projectId,
                                @JsonProperty("userId") @Nonnull UserId loadedBy,
                                @JsonProperty("projectDetails") @Nonnull ProjectDetails projectDetails) implements Result {

    public LoadProjectResult(@JsonProperty("projectId") @Nonnull ProjectId projectId,
                             @JsonProperty("userId") @Nonnull UserId loadedBy,
                             @JsonProperty("projectDetails") @Nonnull ProjectDetails projectDetails) {
        this.projectId = checkNotNull(projectId);
        this.loadedBy = checkNotNull(loadedBy);
        this.projectDetails = checkNotNull(projectDetails);
    }
}

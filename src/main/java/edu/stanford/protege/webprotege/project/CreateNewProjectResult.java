package edu.stanford.protege.webprotege.project;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.dispatch.Result;
import edu.stanford.protege.webprotege.project.ProjectDetails;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 21/02/15
 */
@JsonTypeName("CreateNewProject")
public record CreateNewProjectResult(ProjectDetails projectDetails) implements Result {

    public CreateNewProjectResult(ProjectDetails projectDetails) {
        this.projectDetails = checkNotNull(projectDetails);
    }
}

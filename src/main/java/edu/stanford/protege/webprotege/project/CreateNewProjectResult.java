package edu.stanford.protege.webprotege.project;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.Response;
import edu.stanford.protege.webprotege.dispatch.Result;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 21/02/15
 */
@JsonTypeName("webprotege.projects.CreateNewProject")
public record CreateNewProjectResult(ProjectDetails projectDetails) implements Result, Response {

    public CreateNewProjectResult(ProjectDetails projectDetails) {
        this.projectDetails = checkNotNull(projectDetails);
    }
}

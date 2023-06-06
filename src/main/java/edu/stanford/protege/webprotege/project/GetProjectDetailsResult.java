package edu.stanford.protege.webprotege.project;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.dispatch.Result;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 10/03/16
 */


@JsonTypeName("webprotege.projects.GetProjectDetails")
public record GetProjectDetailsResult(ProjectDetails projectDetails) implements Result {

    public GetProjectDetailsResult(ProjectDetails projectDetails) {
        this.projectDetails = checkNotNull(projectDetails);
    }
}

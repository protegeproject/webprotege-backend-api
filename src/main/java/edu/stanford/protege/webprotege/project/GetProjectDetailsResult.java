package edu.stanford.protege.webprotege.project;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.dispatch.Result;
import edu.stanford.protege.webprotege.project.ProjectDetails;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 10/03/16
 */


@JsonTypeName("webprotege.projects.GetProjectDetails")
public record GetProjectDetailsResult(ProjectDetails projectDetails) implements Result {

}

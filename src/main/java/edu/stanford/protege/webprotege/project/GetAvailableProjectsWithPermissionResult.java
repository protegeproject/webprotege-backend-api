package edu.stanford.protege.webprotege.project;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.dispatch.Result;
import edu.stanford.protege.webprotege.project.ProjectDetails;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2020-04-14
 */


@JsonTypeName(value = "webprotege.projects.GetAvailableProjectsWithPermission")
public record GetAvailableProjectsWithPermissionResult(ImmutableList<ProjectDetails> projectDetails) implements Result {

}

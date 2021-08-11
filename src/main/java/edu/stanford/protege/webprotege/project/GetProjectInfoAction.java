package edu.stanford.protege.webprotege.project;


import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 21 Aug 2018
 */
public record GetProjectInfoAction(ProjectId projectId) implements ProjectAction<GetProjectInfoResult> {

}

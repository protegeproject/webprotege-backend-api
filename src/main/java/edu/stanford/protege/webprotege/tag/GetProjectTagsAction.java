package edu.stanford.protege.webprotege.tag;


import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 18 Mar 2018
 */
public record GetProjectTagsAction(ProjectId projectId) implements ProjectAction<GetProjectTagsResult> {

}

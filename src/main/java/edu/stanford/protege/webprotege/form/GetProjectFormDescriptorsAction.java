package edu.stanford.protege.webprotege.form;

import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2019-11-20
 */
public record GetProjectFormDescriptorsAction(ProjectId projectId) implements ProjectAction<GetProjectFormDescriptorsResult> {

}

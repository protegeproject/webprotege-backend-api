package edu.stanford.protege.webprotege.sharing;

import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 07/02/15
 */
public record GetProjectSharingSettingsAction(ProjectId projectId) implements ProjectAction<GetProjectSharingSettingsResult> {

}

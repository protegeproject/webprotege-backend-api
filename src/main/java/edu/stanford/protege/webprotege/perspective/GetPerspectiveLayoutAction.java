package edu.stanford.protege.webprotege.perspective;

import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import edu.stanford.protege.webprotege.project.HasProjectId;
import edu.stanford.protege.webprotege.user.UserId;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 17/02/16
 */
public record GetPerspectiveLayoutAction(ProjectId projectId, UserId userId, PerspectiveId perspectiveId) implements ProjectAction<GetPerspectiveLayoutResult>, HasProjectId {

}

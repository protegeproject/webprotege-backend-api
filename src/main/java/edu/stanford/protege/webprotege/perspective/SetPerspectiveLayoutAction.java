package edu.stanford.protege.webprotege.perspective;

import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import edu.stanford.protege.webprotege.user.UserId;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 28/02/16
 */
public record SetPerspectiveLayoutAction(ProjectId projectId, UserId userId, PerspectiveLayout layout) implements ProjectAction<SetPerspectiveLayoutResult> {
}

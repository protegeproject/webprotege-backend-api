package edu.stanford.protege.webprotege.perspective;


import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ChangeRequest;
import edu.stanford.protege.webprotege.common.ChangeRequestId;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 15 Mar 2017
 *
 * Requests that the perspective identified by the specified id in the specified project is reset to
 * the default for the current user.
 * @param changeRequestId
 * @param projectId The project id.
 * @param perspectiveId The perspective id.
 */
@JsonTypeName("webprotege.perspectives.ResetPerspectiveLayout")
public record ResetPerspectiveLayoutAction(ChangeRequestId changeRequestId,
                                           ProjectId projectId,
                                           PerspectiveId perspectiveId) implements ProjectAction<ResetPerspectiveLayoutResult>, ChangeRequest {

    public static final String CHANNEL = "webprotege.perspectives.ResetPerspectiveLayout";

    @Override
    public String getChannel() {
        return CHANNEL;
    }

    public ResetPerspectiveLayoutAction(ChangeRequestId changeRequestId, ProjectId projectId, PerspectiveId perspectiveId) {
        this.changeRequestId = checkNotNull(changeRequestId);
        this.projectId = checkNotNull(projectId);
        this.perspectiveId = checkNotNull(perspectiveId);
    }
}

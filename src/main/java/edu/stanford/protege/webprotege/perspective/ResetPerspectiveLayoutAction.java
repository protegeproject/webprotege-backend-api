package edu.stanford.protege.webprotege.perspective;


import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 15 Mar 2017
 *
 * Requests that the perspective identified by the specified id in the specified project is reset to
 * the default for the current user.
 * @param projectId The project id.
 * @param perspectiveId The perspective id.
 */
@JsonTypeName("webprotege.perspectives.ResetPerspectiveLayout")
public record ResetPerspectiveLayoutAction(ProjectId projectId,
                                          PerspectiveId perspectiveId) implements ProjectAction<ResetPerspectiveLayoutResult> {

    public static final String CHANNEL = "webprotege.perspectives.ResetPerspectiveLayout";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

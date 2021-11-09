package edu.stanford.protege.webprotege.perspective;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import edu.stanford.protege.webprotege.common.UserId;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 28/02/16
 */
@JsonTypeName("webprotege.perspectives.SetPerspectiveLayout")
public record SetPerspectiveLayoutAction(ProjectId projectId, UserId userId, PerspectiveLayout layout) implements ProjectAction<SetPerspectiveLayoutResult> {

    public static final String CHANNEL = "webprotege.perspectives.SetPerspectiveLayout";

    @Override
    public String getChannel() {
        return CHANNEL;
    }

    public SetPerspectiveLayoutAction(ProjectId projectId, UserId userId, PerspectiveLayout layout) {
        this.projectId = checkNotNull(projectId);
        this.userId = checkNotNull(userId);
        this.layout = checkNotNull(layout);
    }
}

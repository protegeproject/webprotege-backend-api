package edu.stanford.protege.webprotege.permissions;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.Action;
import edu.stanford.protege.webprotege.common.UserId;

import javax.annotation.Nonnull;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 23/02/15
 */
@JsonTypeName("webprotege.auth.GetProjectPermissions")
public record GetProjectPermissionsAction(@Nonnull ProjectId projectId, @Nonnull UserId userId) implements Action<GetProjectPermissionsResult> {

    public static final String CHANNEL = "webprotege.auth.GetProjectPermissions";

    @Override
    public String getChannel() {
        return CHANNEL;
    }

    public GetProjectPermissionsAction(@Nonnull ProjectId projectId, @Nonnull UserId userId) {
        this.projectId = checkNotNull(projectId);
        this.userId = checkNotNull(userId);
    }
}

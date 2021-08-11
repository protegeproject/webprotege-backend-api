package edu.stanford.protege.webprotege.permissions;

import com.google.common.base.Objects;
import edu.stanford.protege.webprotege.HasUserId;
import edu.stanford.protege.webprotege.dispatch.Action;
import edu.stanford.protege.webprotege.project.HasProjectId;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.user.UserId;

import javax.annotation.Nonnull;

import static com.google.common.base.MoreObjects.toStringHelper;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 23/02/15
 */
public record GetProjectPermissionsAction(@Nonnull ProjectId projectId, @Nonnull UserId userId) implements Action<GetProjectPermissionsResult> {

}

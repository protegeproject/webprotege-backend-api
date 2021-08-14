package edu.stanford.protege.webprotege.permissions;

import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.Action;
import edu.stanford.protege.webprotege.common.UserId;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 23/02/15
 */
public record GetProjectPermissionsAction(@Nonnull ProjectId projectId, @Nonnull UserId userId) implements Action<GetProjectPermissionsResult> {

}

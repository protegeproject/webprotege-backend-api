package edu.stanford.protege.webprotege.perspective;

import com.google.common.base.Objects;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import edu.stanford.protege.webprotege.project.HasProjectId;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.user.UserId;

import javax.annotation.Nonnull;

import static com.google.common.base.MoreObjects.toStringHelper;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 17/02/16
 */
public record GetPerspectiveLayoutAction(ProjectId projectId, UserId userId, PerspectiveId perspectiveId) implements ProjectAction<GetPerspectiveLayoutResult>, HasProjectId {

}

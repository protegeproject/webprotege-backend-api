package edu.stanford.protege.webprotege.sharing;

import com.google.common.base.Objects;
import edu.stanford.protege.webprotege.dispatch.Result;

import static com.google.common.base.MoreObjects.toStringHelper;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 07/02/15
 */
public record GetProjectSharingSettingsResult(ProjectSharingSettings settings) implements Result {

}

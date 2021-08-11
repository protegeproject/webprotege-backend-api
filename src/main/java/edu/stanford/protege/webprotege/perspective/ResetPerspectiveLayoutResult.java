package edu.stanford.protege.webprotege.perspective;


import edu.stanford.protege.webprotege.dispatch.Result;

import javax.annotation.Nonnull;
import java.util.Objects;

import static com.google.common.base.MoreObjects.toStringHelper;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 15 Mar 2017
 */
public record ResetPerspectiveLayoutResult(@Nonnull PerspectiveLayout resetLayout) implements Result {

}

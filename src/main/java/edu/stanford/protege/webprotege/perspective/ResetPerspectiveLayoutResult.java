package edu.stanford.protege.webprotege.perspective;


import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.dispatch.Result;

import javax.annotation.Nonnull;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 15 Mar 2017
 */
@JsonTypeName("webprotege.perspectives.ResetPerspectiveLayout")
public record ResetPerspectiveLayoutResult(@Nonnull PerspectiveLayout resetLayout) implements Result {

    public ResetPerspectiveLayoutResult(@Nonnull PerspectiveLayout resetLayout) {
        this.resetLayout = checkNotNull(resetLayout);
    }
}

package edu.stanford.protege.webprotege.perspective;


import edu.stanford.protege.webprotege.dispatch.Result;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 15 Mar 2017
 */
public record ResetPerspectiveLayoutResult(@Nonnull PerspectiveLayout resetLayout) implements Result {

}

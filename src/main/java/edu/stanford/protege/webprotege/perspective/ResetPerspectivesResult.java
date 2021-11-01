package edu.stanford.protege.webprotege.perspective;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.dispatch.Result;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2020-09-03
 */


@JsonTypeName("webprotege.perspectives.ResetPerspectives")
public record ResetPerspectivesResult() implements Result {

}

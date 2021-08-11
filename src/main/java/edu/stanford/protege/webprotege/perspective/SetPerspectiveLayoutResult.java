package edu.stanford.protege.webprotege.perspective;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.dispatch.Result;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 28/02/16
 */


@JsonTypeName("SetPerspectiveLayout")
public record SetPerspectiveLayoutResult() implements Result {
}

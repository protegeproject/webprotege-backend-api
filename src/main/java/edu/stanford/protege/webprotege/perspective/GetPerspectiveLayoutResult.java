package edu.stanford.protege.webprotege.perspective;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.dispatch.Result;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 17/02/16
 */


@JsonTypeName("webprotege.perspectives.GetPerspectiveLayout")
public record GetPerspectiveLayoutResult(PerspectiveLayout layout) implements Result {

}

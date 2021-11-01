package edu.stanford.protege.webprotege.bulkop;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.dispatch.Result;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 24 Sep 2018
 */


@JsonTypeName("webprotege.bulkop.SetAnnotationValue")
public record SetAnnotationValueResult() implements Result {
}

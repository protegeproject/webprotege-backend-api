package edu.stanford.protege.webprotege.form;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.dispatch.Result;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2020-08-22
 */


@JsonTypeName("UpdateFormDescriptor")
public record UpdateFormDescriptorResult() implements Result {
}

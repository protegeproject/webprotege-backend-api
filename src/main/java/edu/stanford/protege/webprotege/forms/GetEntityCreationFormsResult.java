package edu.stanford.protege.webprotege.forms;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.dispatch.Result;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2020-09-28
 */


@JsonTypeName("GetEntityCreationForms")
public record GetEntityCreationFormsResult(ImmutableList<FormDescriptorDto> formDescriptors) implements Result {

}

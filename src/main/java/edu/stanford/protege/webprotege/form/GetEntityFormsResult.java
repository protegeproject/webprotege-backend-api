package edu.stanford.protege.webprotege.form;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.dispatch.Result;
import edu.stanford.protege.webprotege.entity.OWLEntityData;
import edu.stanford.protege.webprotege.form.data.FormDataDto;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2019-11-01
 */


@JsonTypeName("GetEntityForms")
public record GetEntityFormsResult(OWLEntityData entityData,
                                   ImmutableList<FormId> filteredFormIds,
                                   ImmutableList<FormDataDto> formData) implements Result {
}

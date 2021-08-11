package edu.stanford.protege.webprotege.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.auto.value.AutoValue;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import edu.stanford.protege.webprotege.form.data.FormData;
import edu.stanford.protege.webprotege.common.ProjectId;
import org.semanticweb.owlapi.model.EntityType;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2020-09-30
 */
@JsonTypeName("CreateEntityFromFormData")
public record CreateEntityFromFormDataAction(@Nonnull ProjectId projectId,
                                             @Nonnull EntityType<?> entityType,
                                             @Nonnull FreshEntityIri freshEntityIri,
                                             @Nonnull FormData formData) implements ProjectAction<CreateEntityFromFormDataResult> {
}

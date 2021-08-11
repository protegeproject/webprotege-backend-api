package edu.stanford.protege.webprotege.form;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.auto.value.AutoValue;
import edu.stanford.protege.webprotege.dispatch.Result;
import edu.stanford.protege.webprotege.match.criteria.CompositeRootCriteria;
import edu.stanford.protege.webprotege.common.ProjectId;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Optional;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2020-01-16
 */


@JsonTypeName("GetEntityFormDescriptor")
public record GetEntityFormDescriptorResult(@JsonProperty("projectId") @Nonnull ProjectId projectId,
                                            @JsonProperty("formId") @Nonnull FormId formId,
                                            @JsonProperty("formDescriptor") @Nullable FormDescriptor formDescriptor,
                                            @JsonProperty("purpose") @Nonnull FormPurpose purpose,
                                            @Nullable CompositeRootCriteria selectorCriteria) implements Result {
}

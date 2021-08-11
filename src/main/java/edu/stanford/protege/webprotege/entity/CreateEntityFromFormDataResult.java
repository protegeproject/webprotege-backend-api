package edu.stanford.protege.webprotege.entity;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.collect.ImmutableCollection;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.Result;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2020-09-30
 */
@JsonTypeName("CreateEntityFromFormData")
public record CreateEntityFromFormDataResult(@Nonnull ProjectId projectId,
                                             ImmutableCollection<EntityNode> entities) implements Result {
}

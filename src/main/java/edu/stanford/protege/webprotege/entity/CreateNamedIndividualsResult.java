package edu.stanford.protege.webprotege.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.common.ChangeRequestId;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.Result;

import javax.annotation.Nonnull;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 12/09/2013
 */
@JsonTypeName("webprotege.entities.CreateNamedIndividuals")
public record CreateNamedIndividualsResult(@JsonProperty("projectId") @Nonnull ProjectId projectId,
                                           @JsonProperty("entities") ImmutableSet<EntityNode> entities,
                                           @JsonProperty("changeRequestId") ChangeRequestId changeRequestId) implements Result {
}

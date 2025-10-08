package edu.stanford.protege.webprotege.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.common.ChangeRequestId;
import edu.stanford.protege.webprotege.common.ProjectId;
import org.semanticweb.owlapi.model.OWLObjectProperty;

import javax.annotation.Nonnull;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 25/03/2013
 */


@JsonTypeName("webprotege.entities.CreateObjectProperties")
public record CreateObjectPropertiesResult(@JsonProperty("projectId") @Nonnull ProjectId projectId,
                                           @JsonProperty("entities") @Nonnull ImmutableSet<EntityNode> entities,
                                           @JsonProperty("changeRequestId") ChangeRequestId changeRequestId) implements CreateEntitiesInHierarchyResult<OWLObjectProperty> {

}

package edu.stanford.protege.webprotege.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.common.ProjectId;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;

import javax.annotation.Nonnull;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 25/03/2013
 */


@JsonTypeName("webprotege.entities.CreateAnnotationProperties")
public record CreateAnnotationPropertiesResult(@JsonProperty("projectId") @Nonnull ProjectId projectId,
                                               @JsonProperty("entities") @Nonnull ImmutableSet<EntityNode> entities) implements CreateEntitiesInHierarchyResult<OWLAnnotationProperty> {

}

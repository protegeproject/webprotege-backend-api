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
public record CreateAnnotationPropertiesAction(@JsonProperty("projectId") @Nonnull ProjectId projectId,
                                               @JsonProperty("sourceText") @Nonnull String sourceText,
                                               @JsonProperty("langTag") @Nonnull String langTag,
                                               @JsonProperty("parents") @Nonnull ImmutableSet<OWLAnnotationProperty> parents) implements CreateEntitiesInHierarchyAction<CreateAnnotationPropertiesResult, OWLAnnotationProperty> {

    public static final String CHANNEL = "webprotege.entities.CreateAnnotationProperties";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

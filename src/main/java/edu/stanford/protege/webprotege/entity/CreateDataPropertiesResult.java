package edu.stanford.protege.webprotege.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.event.EventList;
import edu.stanford.protege.webprotege.event.ProjectEvent;
import edu.stanford.protege.webprotege.project.ProjectId;
import org.semanticweb.owlapi.model.OWLDataProperty;

import javax.annotation.Nonnull;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 25/03/2013
 */
@AutoValue

@JsonTypeName("CreateDataProperties")
public abstract class CreateDataPropertiesResult implements CreateEntitiesInHierarchyResult<OWLDataProperty> {

    @JsonCreator
    public static CreateDataPropertiesResult create(@JsonProperty("projectId") @Nonnull ProjectId projectId,
                                      @JsonProperty("entities") @Nonnull ImmutableSet<EntityNode> entities,
                                      @JsonProperty("eventList") @Nonnull EventList<ProjectEvent> eventList) {
        return new AutoValue_CreateDataPropertiesResult(projectId, eventList, entities);
    }
}

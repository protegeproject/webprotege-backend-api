package edu.stanford.protege.webprotege.hierarchy;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.EventId;
import edu.stanford.protege.webprotege.common.ProjectEvent;
import edu.stanford.protege.webprotege.common.ProjectId;

import javax.annotation.Nonnull;
import java.util.Objects;

/**
 * Matthew Horridge Stanford Center for Biomedical Informatics Research 1 Dec 2017
 */
@JsonTypeName("webprotege.events.hierarchies.EntityHierarchyChanged")
public record EntityHierarchyChangedEvent(@JsonProperty("eventId") @Nonnull EventId eventId,
                                          @JsonProperty("projectId") @Nonnull ProjectId projectId,
                                          @JsonProperty("hierarchyDescriptor") @Nonnull HierarchyDescriptor hierarchyDescriptor,
                                          @JsonProperty("changeEvent") @Nonnull GraphModelChangedEvent changeEvent) implements ProjectEvent {

    public static final String CHANNEL = "webprotege.events.hierarchies.EntityHierarchyChanged";

    public EntityHierarchyChangedEvent(@JsonProperty("eventId") @Nonnull EventId eventId, @JsonProperty("projectId") @Nonnull ProjectId projectId, @JsonProperty("hierarchyDescriptor") @Nonnull HierarchyDescriptor hierarchyDescriptor, @JsonProperty("changeEvent") @Nonnull GraphModelChangedEvent changeEvent) {
        this.eventId = Objects.requireNonNull(eventId);
        this.projectId = Objects.requireNonNull(projectId);
        this.hierarchyDescriptor = Objects.requireNonNull(hierarchyDescriptor);
        this.changeEvent = Objects.requireNonNull(changeEvent);
    }

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

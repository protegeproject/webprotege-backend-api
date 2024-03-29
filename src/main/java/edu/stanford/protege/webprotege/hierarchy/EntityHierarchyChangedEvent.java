package edu.stanford.protege.webprotege.hierarchy;


import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.EventId;
import edu.stanford.protege.webprotege.common.ProjectEvent;
import edu.stanford.protege.webprotege.common.ProjectId;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge Stanford Center for Biomedical Informatics Research 1 Dec 2017
 */
@JsonTypeName("webprotege.events.hierarchies.EntityHierarchyChanged")
public record EntityHierarchyChangedEvent(@Nonnull EventId eventId,
                                          @Nonnull ProjectId projectId,
                                         @Nonnull HierarchyId hierarchyId,
                                         @Nonnull GraphModelChangedEvent changeEvent) implements ProjectEvent {

    public static final String CHANNEL = "webprotege.events.hierarchies.EntityHierarchyChanged";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

package edu.stanford.protege.webprotege.hierarchy;


import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.Event;
import edu.stanford.protege.webprotege.common.ProjectEvent;
import edu.stanford.protege.webprotege.common.ProjectId;

import javax.annotation.Nonnull;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge Stanford Center for Biomedical Informatics Research 1 Dec 2017
 */
@JsonTypeName("webprotege.hierarchies.events.EntityHierarchyChanged")
public record EntityHierarchyChangedEvent(@Nonnull ProjectId projectId,
                                         @Nonnull HierarchyId hierarchyId,
                                         @Nonnull GraphModelChangedEvent changeEvent) implements ProjectEvent {

    public static final String CHANNEL = "webprotege.hierarchies.events.EntityHierarchyChanged";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

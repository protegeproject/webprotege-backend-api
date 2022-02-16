package edu.stanford.protege.webprotege.permissions;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.base.Objects;
import edu.stanford.protege.webprotege.common.Event;
import edu.stanford.protege.webprotege.common.EventId;
import edu.stanford.protege.webprotege.common.ProjectEvent;
import edu.stanford.protege.webprotege.common.ProjectId;
import javax.annotation.Nonnull;

import static com.google.common.base.MoreObjects.toStringHelper;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 03/04/2013
 *
 * An event that is fired when the permissions for a project change.
 */
@JsonTypeName("webprotege.events.projects.PermissionsChanged")
public record PermissionsChangedEvent(EventId eventId,
                                      ProjectId projectId) implements ProjectEvent {

    public static final String CHANNEL = "webprotege.events.projects.PermissionsChanged";

    @Override
    public String getChannel() {
        return CHANNEL;
    }

    public PermissionsChangedEvent(EventId eventId, ProjectId projectId) {
        this.eventId = checkNotNull(eventId);
        this.projectId = checkNotNull(projectId);
    }
}

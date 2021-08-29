package edu.stanford.protege.webprotege.permissions;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.base.Objects;
import edu.stanford.protege.webprotege.common.Event;
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
@JsonTypeName("PermissionsChangedEvent")
public record PermissionsChangedEvent(ProjectId projectId) implements ProjectEvent {

    public static final String CHANNEL = "webprotege.projects.events.PermissionsChanged";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

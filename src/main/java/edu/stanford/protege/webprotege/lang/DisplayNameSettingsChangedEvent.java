package edu.stanford.protege.webprotege.lang;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import edu.stanford.protege.webprotege.event.ProjectEvent;
import edu.stanford.protege.webprotege.project.ProjectId;

import javax.annotation.Nonnull;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 29 Jul 2018
 */
public class DisplayNameSettingsChangedEvent extends ProjectEvent {

    @Nonnull
    private final DisplayNameSettings displayNameSettings;

    private DisplayNameSettingsChangedEvent(@Nonnull ProjectId source,
                                            @Nonnull DisplayNameSettings displayNameSettings) {
        super(source);
        this.displayNameSettings = checkNotNull(displayNameSettings);
    }

    @JsonCreator
    public static DisplayNameSettingsChangedEvent get(@JsonProperty("projectId") @Nonnull ProjectId projectId,
                                                      @JsonProperty("displayNameSettings") @Nonnull DisplayNameSettings displayNameSettings) {
        return new DisplayNameSettingsChangedEvent(projectId, displayNameSettings);
    }

    @Nonnull
    public DisplayNameSettings getDisplayNameSettings() {
        return displayNameSettings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DisplayNameSettingsChangedEvent)) {
            return false;
        }
        DisplayNameSettingsChangedEvent that = (DisplayNameSettingsChangedEvent) o;
        return displayNameSettings.equals(that.displayNameSettings)
                && getProjectId().equals(that.getProjectId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(displayNameSettings, getProjectId());
    }
}

package edu.stanford.protege.webprotege.lang;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.EventId;
import edu.stanford.protege.webprotege.common.ProjectEvent;
import edu.stanford.protege.webprotege.common.ProjectId;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 29 Jul 2018
 */
@JsonTypeName("webprotege.events.projects.DisplayNameSettingsChanged")
public record DisplayNameSettingsChangedEvent(EventId eventId,
                                              ProjectId projectId,
                                              DisplayNameSettings displayNameSettings) implements ProjectEvent {

    public static final String CHANNEL = "webprotege.events.projects.DisplayNameSettingsChanged";


    @JsonCreator
    public static DisplayNameSettingsChangedEvent get(@JsonProperty("eventId") EventId eventId,
                                                      @JsonProperty("projectId") @Nonnull ProjectId projectId,
                                                      @JsonProperty("displayNameSettings") @Nonnull DisplayNameSettings displayNameSettings) {
        return new DisplayNameSettingsChangedEvent(eventId, projectId, displayNameSettings);
    }

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

package edu.stanford.protege.webprotege.projectsettings;


import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.Event;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 25/11/14
 */
@JsonTypeName("ProjectSettingsChangedEvent")
public record ProjectSettingsChangedEvent(ProjectSettings projectSettings) implements Event {

    public static final String CHANNEL = "webprotege.project.events.ProjectSettingsChanged";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

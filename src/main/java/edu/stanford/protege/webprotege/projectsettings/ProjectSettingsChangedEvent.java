package edu.stanford.protege.webprotege.projectsettings;


import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.Event;
import edu.stanford.protege.webprotege.common.ProjectEvent;
import edu.stanford.protege.webprotege.common.ProjectId;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 25/11/14
 */
@JsonTypeName("webprotege.events.project.ProjectSettingsChanged")
public record ProjectSettingsChangedEvent(ProjectId projectId, ProjectSettings projectSettings) implements ProjectEvent {

    public static final String CHANNEL = "webprotege.events.project.ProjectSettingsChanged";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

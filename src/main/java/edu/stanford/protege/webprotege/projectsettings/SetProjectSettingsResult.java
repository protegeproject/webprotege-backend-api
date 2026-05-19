package edu.stanford.protege.webprotege.projectsettings;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.dispatch.Result;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 25/11/14
 */
@JsonTypeName("webprotege.projects.SetProjectSettings")
public record SetProjectSettingsResult(@JsonProperty("settings") ProjectSettings settings) implements Result {

    public SetProjectSettingsResult(ProjectSettings settings) {
        this.settings = checkNotNull(settings);
    }
}

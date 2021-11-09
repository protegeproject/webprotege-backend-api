package edu.stanford.protege.webprotege.projectsettings;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.dispatch.Result;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 25/11/14
 */
@JsonTypeName("webprotege.projects.GetProjectSettings")
public record GetProjectSettingsResult(ProjectSettings settings) implements Result {

    public GetProjectSettingsResult(ProjectSettings settings) {
        this.settings = checkNotNull(settings);
    }
}


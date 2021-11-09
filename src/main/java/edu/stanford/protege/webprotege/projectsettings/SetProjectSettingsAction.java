package edu.stanford.protege.webprotege.projectsettings;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 25/11/14
 */
@JsonTypeName("webprotege.projects.SetProjectSettings")
public record SetProjectSettingsAction(ProjectId projectId,
                                       ProjectSettings settings) implements ProjectAction<SetProjectSettingsResult> {

    public static final String CHANNEL = "webprotege.projects.SetProjectSettings";

    @Override
    public String getChannel() {
        return CHANNEL;
    }

    public SetProjectSettingsAction(ProjectId projectId, ProjectSettings settings) {
        this.projectId = checkNotNull(projectId);
        this.settings = checkNotNull(settings);
    }
}

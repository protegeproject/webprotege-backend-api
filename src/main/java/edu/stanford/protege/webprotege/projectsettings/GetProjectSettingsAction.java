package edu.stanford.protege.webprotege.projectsettings;

import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 25/11/14
 */
public record GetProjectSettingsAction(ProjectId projectId) implements ProjectAction<GetProjectSettingsResult> {

    public static final String CHANNEL = "webprotege.projects.GetProjectSettings";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

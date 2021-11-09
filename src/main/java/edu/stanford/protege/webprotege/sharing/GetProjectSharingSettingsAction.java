package edu.stanford.protege.webprotege.sharing;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 07/02/15
 */
@JsonTypeName("webprotege.projects.GetProjectSharingSettings")
public record GetProjectSharingSettingsAction(ProjectId projectId) implements ProjectAction<GetProjectSharingSettingsResult> {

    public static final String CHANNEL = "webprotege.projects.GetProjectSharingSettings";

    @Override
    public String getChannel() {
        return CHANNEL;
    }

    public GetProjectSharingSettingsAction(ProjectId projectId) {
        this.projectId = checkNotNull(projectId);
    }
}

package edu.stanford.protege.webprotege.sharing;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ChangeRequest;
import edu.stanford.protege.webprotege.common.ChangeRequestId;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 07/02/15
 */
@JsonTypeName("webprotege.sharing.SetProjectSharingSettings")
public record SetProjectSharingSettingsAction(ChangeRequestId changeRequestId,
                                              ProjectId projectId, ProjectSharingSettings settings) implements ProjectAction<SetProjectSharingSettingsResult>, ChangeRequest {

    public static final String CHANNEL = "webprotege.sharing.SetProjectSharingSettings";

    @Override
    public String getChannel() {
        return CHANNEL;
    }

    public SetProjectSharingSettingsAction(ChangeRequestId changeRequestId, ProjectId projectId, ProjectSharingSettings settings) {
        this.changeRequestId = checkNotNull(changeRequestId);
        this.projectId = checkNotNull(projectId);
        this.settings = checkNotNull(settings);
    }
}

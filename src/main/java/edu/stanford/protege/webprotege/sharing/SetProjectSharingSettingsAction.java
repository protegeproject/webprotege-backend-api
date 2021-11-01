package edu.stanford.protege.webprotege.sharing;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 07/02/15
 */
@JsonTypeName("webprotege.sharing.SetProjectSharingSettings")
public record SetProjectSharingSettingsAction(ProjectId projectId, ProjectSharingSettings settings) implements ProjectAction<SetProjectSharingSettingsResult> {

    public static final String CHANNEL = "webprotege.sharing.SetProjectSharingSettings";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

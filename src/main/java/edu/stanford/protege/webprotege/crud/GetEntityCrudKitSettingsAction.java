package edu.stanford.protege.webprotege.crud;

import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;

import javax.annotation.Nonnull;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 8/19/13
 */
public record GetEntityCrudKitSettingsAction(ProjectId projectId) implements ProjectAction<GetEntityCrudKitSettingsResult> {

    public static final String CHANNEL = "webprotege.projects.GetEntityCrudKitSettings";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

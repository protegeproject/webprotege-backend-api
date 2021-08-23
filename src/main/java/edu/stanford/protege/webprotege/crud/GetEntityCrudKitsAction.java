package edu.stanford.protege.webprotege.crud;

import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 8/19/13
 */
public record GetEntityCrudKitsAction(ProjectId projectId) implements ProjectAction<GetEntityCrudKitsResult> {

    public static final String CHANNEL = "webprotege.entities.GetEntityCrudKits";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}


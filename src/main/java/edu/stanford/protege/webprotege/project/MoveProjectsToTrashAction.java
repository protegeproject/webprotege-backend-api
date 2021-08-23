package edu.stanford.protege.webprotege.project;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.Action;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 19/04/2013
 */


@JsonTypeName("MoveProjectToTrash")
public record MoveProjectsToTrashAction(ProjectId projectId) implements Action<MoveProjectsToTrashResult> {

    public static final String CHANNEL = "webprotege.projects.MoveProjectToTrash";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

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


@JsonTypeName("RemoveProjectFromTrash")
public record RemoveProjectFromTrashAction(ProjectId projectId) implements Action<RemoveProjectFromTrashResult> {

    public static final String CHANNEL = "webprotege.projects.RemoveProjectFromTrash";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

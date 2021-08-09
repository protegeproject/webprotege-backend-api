package edu.stanford.protege.webprotege.event;


import edu.stanford.protege.webprotege.common.ProjectId;

import java.util.Objects;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 09/04/2013
 */
public class ProjectMovedFromTrashEvent extends WebProtegeEvent {

    private ProjectId projectId;

    private ProjectMovedFromTrashEvent() {
    }

    public ProjectMovedFromTrashEvent(ProjectId projectId) {
        this.projectId = projectId;
    }

    public ProjectId getProjectId() {
        return projectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProjectMovedFromTrashEvent)) {
            return false;
        }
        ProjectMovedFromTrashEvent that = (ProjectMovedFromTrashEvent) o;
        return Objects.equals(projectId, that.projectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId);
    }
}

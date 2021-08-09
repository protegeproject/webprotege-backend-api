package edu.stanford.protege.webprotege.project;

import edu.stanford.protege.webprotege.common.ProjectId;

import java.io.Serializable;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 14/05/2012
 */
public abstract class ProjectAlreadyExistsException extends ProjectCreationException implements Serializable {

    protected ProjectAlreadyExistsException() {
        super();
    }

    protected ProjectAlreadyExistsException(ProjectId projectId, String message) {
        super(projectId, message);
    }

    public ProjectAlreadyExistsException(ProjectId projectId) {
        super(projectId, "Project already exists: " + projectId);
    }

}

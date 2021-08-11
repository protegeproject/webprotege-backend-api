package edu.stanford.protege.webprotege.dispatch;

import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.project.HasProjectId;
import org.jetbrains.annotations.NotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-08-07
 */
public interface ProjectAction<R extends Result> extends Action<R>, HasProjectId {

    ProjectId projectId();

    @NotNull
    default ProjectId getProjectId() {
        return projectId();
    }
}

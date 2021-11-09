package edu.stanford.protege.webprotege.project;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.Action;
import org.jetbrains.annotations.NotNull;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 05/04/2013
 */
@JsonTypeName("webprotege.projects.LoadProject")
public record LoadProjectAction(ProjectId projectId) implements Action<LoadProjectResult>, HasProjectId {

    public static final String CHANNEL = "webprotege.projects.LoadProject";

    @Override
    public String getChannel() {
        return CHANNEL;
    }

    public LoadProjectAction(ProjectId projectId) {
        this.projectId = checkNotNull(projectId);
    }
}

package edu.stanford.protege.webprotege.project;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.Action;
import org.jetbrains.annotations.NotNull;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 10/03/16
 */
@JsonTypeName("webprotege.projects.GetProjectDetails")
public record GetProjectDetailsAction(ProjectId projectId) implements Action<GetProjectDetailsResult>, HasProjectId {

    public static final String CHANNEL = "webprotege.projects.GetProjectDetails";

    @Override
    public String getChannel() {
        return CHANNEL;
    }

    public GetProjectDetailsAction(ProjectId projectId) {
        this.projectId = checkNotNull(projectId);
    }
}

package edu.stanford.protege.webprotege.project;


import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 27 Feb 2018
 */
@JsonTypeName("webprotege.projects.GetProjectPrefixDeclarations")
public record GetProjectPrefixDeclarationsRequest(ProjectId projectId) implements ProjectAction<GetProjectPrefixDeclarationsResponse> {

    public static final String CHANNEL = "webprotege.projects.GetProjectPrefixDeclarations";

    @Override
    public String getChannel() {
        return CHANNEL;
    }

    public GetProjectPrefixDeclarationsRequest(ProjectId projectId) {
        this.projectId = checkNotNull(projectId);
    }
}

package edu.stanford.protege.webprotege.project;


import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 27 Feb 2018
 */
public record GetProjectPrefixDeclarationsRequest(ProjectId projectId) implements ProjectAction<GetProjectPrefixDeclarationsResponse> {

    public static final String CHANNEL = "webprotege.projects.GetProjectPrefixDeclarations";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

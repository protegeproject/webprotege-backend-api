package edu.stanford.protege.webprotege.obo;

import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 22 Jun 2017
 */
public record GetOboNamespacesAction(ProjectId projectId) implements ProjectAction<GetOboNamespacesResult> {

    public static final String CHANNEL = "webprotege.obo.GetOboNamespaces";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

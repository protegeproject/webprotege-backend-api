package edu.stanford.protege.webprotege.revision;

import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 21/02/15
 */
public record GetRevisionSummariesAction(ProjectId projectId) implements ProjectAction<GetRevisionSummariesResult> {

    public static final String CHANNEL = "webprotege.history.GetRevisionSummaries";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

package edu.stanford.protege.webprotege.change;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import edu.stanford.protege.webprotege.common.UserId;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 27/02/15
 */
@JsonTypeName("GetWatchedEntityChanges")
public record GetWatchedEntityChangesAction(ProjectId projectId, UserId userId) implements ProjectAction<GetWatchedEntityChangesResult> {

    public static final String CHANNEL = "webprotege.watches.GetWatchedEntityChanges";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

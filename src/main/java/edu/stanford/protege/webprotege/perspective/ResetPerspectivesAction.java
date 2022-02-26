package edu.stanford.protege.webprotege.perspective;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ChangeRequest;
import edu.stanford.protege.webprotege.common.ChangeRequestId;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2020-09-03
 */


@JsonTypeName("webprotege.perspectives.ResetPerspectives")
public record ResetPerspectivesAction(ChangeRequestId changeRequestId,
                                      ProjectId projectId) implements ProjectAction<ResetPerspectivesResult>, ChangeRequest {

    public static final String CHANNEL = "webprotege.perspectives.ResetPerspectives";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

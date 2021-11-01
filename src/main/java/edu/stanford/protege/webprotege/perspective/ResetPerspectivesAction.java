package edu.stanford.protege.webprotege.perspective;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2020-09-03
 */


@JsonTypeName("webprotege.perspectives.ResetPerspectives")
public record ResetPerspectivesAction(ProjectId projectId) implements ProjectAction<ResetPerspectivesResult> {

    public static final String CHANNEL = "webprotege.perspectives.ResetPerspectives";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

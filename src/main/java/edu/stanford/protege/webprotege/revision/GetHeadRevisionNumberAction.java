package edu.stanford.protege.webprotege.revision;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 21/02/15
 */
@JsonTypeName("webprotege.history.GetHeadRevisionNumber")
public record GetHeadRevisionNumberAction(ProjectId projectId) implements ProjectAction<GetHeadRevisionNumberResult> {

    public static final String CHANNEL = "webprotege.history.GetHeadRevisionNumber";

    @Override
    public String getChannel() {
        return CHANNEL;
    }

    public GetHeadRevisionNumberAction(ProjectId projectId) {
        this.projectId = checkNotNull(projectId);
    }
}

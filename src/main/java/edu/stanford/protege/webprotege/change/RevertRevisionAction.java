package edu.stanford.protege.webprotege.change;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ChangeRequestId;
import edu.stanford.protege.webprotege.common.ContentChangeRequest;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import edu.stanford.protege.webprotege.revision.RevisionNumber;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 19/03/15
 */
@JsonTypeName("webprotege.history.RevertRevision")
public record RevertRevisionAction(@JsonProperty("changeRequestId") ChangeRequestId changeRequestId,
                                   @JsonProperty("projectId") ProjectId projectId,
                                   @JsonProperty("revisionNumber") RevisionNumber revisionNumber) implements ProjectAction<RevertRevisionResult>, ContentChangeRequest {

    public static final String CHANNEL = "webprotege.history.RevertRevision";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

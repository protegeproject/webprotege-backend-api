package edu.stanford.protege.webprotege.revision;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.Result;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 21/02/15
 */
@JsonTypeName("webprotege.history.GetHeadRevisionNumber")
public record GetHeadRevisionNumberResult(ProjectId projectId,
                                         RevisionNumber revisionNumber) implements Result {

    public GetHeadRevisionNumberResult(ProjectId projectId, RevisionNumber revisionNumber) {
        this.projectId = checkNotNull(projectId);
        this.revisionNumber = checkNotNull(revisionNumber);
    }
}

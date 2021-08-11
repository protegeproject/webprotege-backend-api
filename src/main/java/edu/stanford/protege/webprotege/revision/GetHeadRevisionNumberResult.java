package edu.stanford.protege.webprotege.revision;

import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.Result;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 21/02/15
 */
public record GetHeadRevisionNumberResult(ProjectId projectId,
                                         RevisionNumber revisionNumber) implements Result {
}

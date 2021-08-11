package edu.stanford.protege.webprotege.revision;

import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 21/02/15
 */
public record GetHeadRevisionNumberAction(ProjectId projectId) implements ProjectAction<GetHeadRevisionNumberResult> {
}

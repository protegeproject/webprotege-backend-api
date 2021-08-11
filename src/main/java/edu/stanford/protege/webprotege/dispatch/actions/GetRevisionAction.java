package edu.stanford.protege.webprotege.dispatch.actions;

import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import edu.stanford.protege.webprotege.revision.RevisionNumber;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 9 May 2018
 *
 * Serverside action only
 */
public record GetRevisionAction(ProjectId projectId,
                               RevisionNumber revisionNumber) implements ProjectAction<GetRevisionResult> {
}

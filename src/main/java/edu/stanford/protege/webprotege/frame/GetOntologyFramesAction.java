package edu.stanford.protege.webprotege.frame;

import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 25/07/15
 */
public record GetOntologyFramesAction(ProjectId projectId) implements ProjectAction<GetOntologyFramesResult> {

}

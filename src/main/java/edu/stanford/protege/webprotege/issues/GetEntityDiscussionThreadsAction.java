package edu.stanford.protege.webprotege.issues;

import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import org.semanticweb.owlapi.model.OWLEntity;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 5 Oct 2016
 */
public record GetEntityDiscussionThreadsAction(@Nonnull ProjectId projectId, @Nonnull OWLEntity entity) implements ProjectAction<GetEntityDiscussionThreadsResult> {
}

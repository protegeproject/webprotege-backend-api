package edu.stanford.protege.webprotege.frame;

import edu.stanford.protege.webprotege.HasSubject;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import edu.stanford.protege.webprotege.common.ProjectId;
import org.semanticweb.owlapi.model.OWLEntity;

import javax.annotation.Nonnull;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author Matthew Horridge, Stanford University, Bio-Medical Informatics Research Group, Date: 18/03/2014
 */
public record GetManchesterSyntaxFrameAction(ProjectId projectId,
                                             OWLEntity subject) implements ProjectAction<GetManchesterSyntaxFrameResult>, HasSubject<OWLEntity> {
}

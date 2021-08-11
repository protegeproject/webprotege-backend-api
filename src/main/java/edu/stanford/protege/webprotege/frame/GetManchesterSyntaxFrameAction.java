package edu.stanford.protege.webprotege.frame;

import edu.stanford.protege.webprotege.HasSubject;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import org.semanticweb.owlapi.model.OWLEntity;

/**
 * @author Matthew Horridge, Stanford University, Bio-Medical Informatics Research Group, Date: 18/03/2014
 */
public record GetManchesterSyntaxFrameAction(ProjectId projectId,
                                             OWLEntity subject) implements ProjectAction<GetManchesterSyntaxFrameResult>, HasSubject<OWLEntity> {
}

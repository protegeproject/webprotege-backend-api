package edu.stanford.protege.webprotege.event;


import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.UserId;
import org.semanticweb.owlapi.model.OWLNamedIndividual;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 18/12/2012
 */
public class NamedIndividualFrameChangedEvent extends EntityFrameChangedEvent<OWLNamedIndividual> {

    public NamedIndividualFrameChangedEvent(OWLNamedIndividual entity, ProjectId projectId, UserId userId) {
        super(entity, projectId, userId);
    }

    private NamedIndividualFrameChangedEvent() {
    }

}

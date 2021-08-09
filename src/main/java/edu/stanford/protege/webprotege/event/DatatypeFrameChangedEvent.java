package edu.stanford.protege.webprotege.event;


import edu.stanford.protege.webprotege.project.ProjectId;
import edu.stanford.protege.webprotege.user.UserId;
import org.semanticweb.owlapi.model.OWLDatatype;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 18/12/2012
 */
public class DatatypeFrameChangedEvent extends EntityFrameChangedEvent<OWLDatatype> {

    public DatatypeFrameChangedEvent(OWLDatatype entity, ProjectId projectId, UserId userId) {
        super(entity, projectId, userId);
    }

    private DatatypeFrameChangedEvent() {
    }

}

package edu.stanford.protege.webprotege.event;


import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.user.UserId;
import org.semanticweb.owlapi.model.OWLDataProperty;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 18/12/2012
 */
public class DataPropertyFrameChangedEvent extends EntityFrameChangedEvent<OWLDataProperty> {

    public DataPropertyFrameChangedEvent(OWLDataProperty entity, ProjectId projectId, UserId userId) {
        super(entity, projectId, userId);
    }

    private DataPropertyFrameChangedEvent() {
    }

}

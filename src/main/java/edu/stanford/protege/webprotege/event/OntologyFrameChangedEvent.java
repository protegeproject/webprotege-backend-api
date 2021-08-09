package edu.stanford.protege.webprotege.event;


import edu.stanford.protege.webprotege.common.ProjectId;
import org.semanticweb.owlapi.model.OWLOntologyID;

import java.io.Serializable;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 18/12/2012
 */
public class OntologyFrameChangedEvent extends ProjectEvent implements Serializable {

    private OWLOntologyID ontologyID;

    public OntologyFrameChangedEvent(OWLOntologyID ontologyID, ProjectId projectId) {
        super(projectId);
        this.ontologyID = ontologyID;
    }

    private OntologyFrameChangedEvent() {

    }


    public OWLOntologyID getOntologyID() {
        return ontologyID;
    }

}

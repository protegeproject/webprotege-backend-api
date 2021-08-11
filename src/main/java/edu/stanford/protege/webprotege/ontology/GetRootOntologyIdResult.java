package edu.stanford.protege.webprotege.ontology;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.Result;
import org.semanticweb.owlapi.model.OWLOntologyID;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 20/02/2013
 */


@JsonTypeName("GetRootOntologyId")
public record GetRootOntologyIdResult(ProjectId projectId,
                                      OWLOntologyID rootOntologyId) implements Result {

}

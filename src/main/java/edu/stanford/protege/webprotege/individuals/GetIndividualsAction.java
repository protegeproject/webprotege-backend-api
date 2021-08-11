package edu.stanford.protege.webprotege.individuals;


import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import edu.stanford.protege.webprotege.pagination.PageRequest;
import org.semanticweb.owlapi.model.OWLClass;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 12/09/2013
 */
public record GetIndividualsAction(ProjectId projectId,
                                  OWLClass type,
                                  PageRequest pageRequest,
                                  String searchString,
                                  InstanceRetrievalMode instanceRetrievalMode) implements ProjectAction<GetIndividualsResult> {
}

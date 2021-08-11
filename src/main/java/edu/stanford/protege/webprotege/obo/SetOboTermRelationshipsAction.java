package edu.stanford.protege.webprotege.obo;

import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import org.semanticweb.owlapi.model.OWLEntity;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 22 Jun 2017
 */
public record SetOboTermRelationshipsAction(ProjectId projectId,
                                            OWLEntity term,
                                            OBOTermRelationships relationships) implements ProjectAction<SetOboTermRelationshipsResult> {
}

package edu.stanford.protege.webprotege.obo;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import org.semanticweb.owlapi.model.OWLEntity;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 22 Jun 2017
 */
@JsonTypeName("GetOBOTermCrossProduct")
public record GetOboTermCrossProductAction(ProjectId projectId,
                                          OWLEntity term) implements ProjectAction<GetOboTermCrossProductResult> {
}

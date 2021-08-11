package edu.stanford.protege.webprotege.obo;


import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import edu.stanford.protege.webprotege.common.ProjectId;
import org.semanticweb.owlapi.model.OWLEntity;

import javax.annotation.Nonnull;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 21 Jun 2017
 */
public record GetOboTermDefinitionAction(ProjectId projectId,
                                         OWLEntity term) implements ProjectAction<GetOboTermDefinitionResult> {
}

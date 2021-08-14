package edu.stanford.protege.webprotege.change;

import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import edu.stanford.protege.webprotege.common.PageRequest;
import org.semanticweb.owlapi.model.OWLEntity;

import javax.annotation.Nonnull;
import java.util.Optional;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 24/02/15
 */
public record GetProjectChangesAction(@Nonnull ProjectId projectId,
                                     @Nonnull Optional<OWLEntity> subject,
                                     @Nonnull PageRequest pageRequest) implements ProjectAction<GetProjectChangesResult> {
}

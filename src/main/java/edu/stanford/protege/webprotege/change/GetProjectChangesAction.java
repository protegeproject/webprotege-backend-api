package edu.stanford.protege.webprotege.change;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import edu.stanford.protege.webprotege.pagination.PageRequest;
import edu.stanford.protege.webprotege.common.ProjectId;
import org.semanticweb.owlapi.model.OWLEntity;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Optional;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 24/02/15
 */
public record GetProjectChangesAction(@Nonnull ProjectId projectId,
                                     @Nonnull Optional<OWLEntity> subject,
                                     @Nonnull PageRequest pageRequest) implements ProjectAction<GetProjectChangesResult> {
}

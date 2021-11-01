package edu.stanford.protege.webprotege.change;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import edu.stanford.protege.webprotege.common.PageRequest;
import org.semanticweb.owlapi.model.OWLEntity;

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.Optional;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 24/02/15
 */
@JsonTypeName("webprotege.history.GetProjectChanges")
public record GetProjectChangesAction(@Nonnull ProjectId projectId,
                                     @Nonnull Optional<OWLEntity> subject,
                                     @Nonnull PageRequest pageRequest) implements ProjectAction<GetProjectChangesResult> {

    public static final String CHANNEL = "webprotege.history.GetProjectChanges";

    public GetProjectChangesAction {
        Objects.requireNonNull(projectId);
        Objects.requireNonNull(subject);
        Objects.requireNonNull(pageRequest);
    }

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

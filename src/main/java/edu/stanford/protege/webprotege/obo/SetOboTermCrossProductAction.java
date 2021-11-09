package edu.stanford.protege.webprotege.obo;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import org.semanticweb.owlapi.model.OWLClass;

import javax.annotation.Nonnull;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 22 Jun 2017
 */
@JsonTypeName("webprotege.obo.SetOboTermCrossProduct")
public record SetOboTermCrossProductAction(@Nonnull ProjectId projectId,
                                          @Nonnull OWLClass term,
                                          @Nonnull OBOTermCrossProduct crossProduct) implements ProjectAction<SetOboTermCrossProductResult> {

    public static final String CHANNEL = "webprotege.obo.SetOboTermCrossProduct";

    @Override
    public String getChannel() {
        return CHANNEL;
    }

    public SetOboTermCrossProductAction(@Nonnull ProjectId projectId,
                                        @Nonnull OWLClass term,
                                        @Nonnull OBOTermCrossProduct crossProduct) {
        this.projectId = checkNotNull(projectId);
        this.term = checkNotNull(term);
        this.crossProduct = checkNotNull(crossProduct);
    }
}

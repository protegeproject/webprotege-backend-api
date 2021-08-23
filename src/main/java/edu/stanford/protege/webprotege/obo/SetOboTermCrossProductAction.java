package edu.stanford.protege.webprotege.obo;

import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import org.semanticweb.owlapi.model.OWLClass;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 22 Jun 2017
 */
public record SetOboTermCrossProductAction(@Nonnull ProjectId projectId,
                                          @Nonnull OWLClass term,
                                          @Nonnull OBOTermCrossProduct crossProduct) implements ProjectAction<SetOboTermCrossProductResult> {

    public static final String CHANNEL = "webprotege.obo.SetOboTermCrossProduct";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

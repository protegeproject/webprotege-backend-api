package edu.stanford.protege.webprotege.obo;

import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import org.semanticweb.owlapi.model.OWLEntity;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 22 Jun 2017
 */
public record SetOboTermXRefsAction(@Nonnull ProjectId projectId, @Nonnull OWLEntity entity, @Nonnull List<OBOXRef> xrefs) implements ProjectAction<SetOboTermXRefsResult> {

    public static final String CHANNEL = "webprotege.obo.SetOboTermXRefs";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

package edu.stanford.protege.webprotege.obo;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import org.semanticweb.owlapi.model.OWLEntity;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 22 Jun 2017
 */
@JsonTypeName("webprotege.obo.GetOboTermXRefs")
public record GetOboTermXRefsAction(@Nonnull ProjectId projectId, @Nonnull OWLEntity entity) implements ProjectAction<GetOboTermXRefsResult> {

    public static final String CHANNEL = "webprotege.obo.GetOboTermXRefs";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

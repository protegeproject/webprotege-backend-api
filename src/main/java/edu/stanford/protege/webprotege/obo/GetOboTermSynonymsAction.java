package edu.stanford.protege.webprotege.obo;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import org.semanticweb.owlapi.model.OWLEntity;

import javax.annotation.Nonnull;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 22 Jun 2017
 */
@JsonTypeName("webprotege.obo.GetOboTermSynonyms")
public record GetOboTermSynonymsAction(@Nonnull ProjectId projectId, @Nonnull OWLEntity term) implements ProjectAction<GetOboTermSynonymsResult> {

    public static final String CHANNEL = "webprotege.obo.GetOboTermSynonyms";

    @Override
    public String getChannel() {
        return CHANNEL;
    }

    public GetOboTermSynonymsAction(@Nonnull ProjectId projectId, @Nonnull OWLEntity term) {
        this.projectId = checkNotNull(projectId);
        this.term = checkNotNull(term);
    }
}

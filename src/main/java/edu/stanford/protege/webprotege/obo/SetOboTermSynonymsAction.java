package edu.stanford.protege.webprotege.obo;

import com.fasterxml.jackson.annotation.JsonTypeName;
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
@JsonTypeName("webprotege.obo.SetOboTermSynonyms")
public record SetOboTermSynonymsAction(@Nonnull ProjectId projectId,
                                      @Nonnull OWLEntity entity,
                                      @Nonnull List<OBOTermSynonym> synonyms) implements ProjectAction<SetOboTermSynonymsResult> {

    public static final String CHANNEL = "webprotege.obo.SetOboTermSynonyms";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

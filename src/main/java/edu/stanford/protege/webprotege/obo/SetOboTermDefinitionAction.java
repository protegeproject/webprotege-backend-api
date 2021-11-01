package edu.stanford.protege.webprotege.obo;

import com.fasterxml.jackson.annotation.JsonProperty;
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
@JsonTypeName("webprotege.obo.SetOboTermDefinition")
public record SetOboTermDefinitionAction(@JsonProperty("projectId") @Nonnull ProjectId projectId,
                                        @Nonnull OWLEntity term,
                                        @JsonProperty("definition") @Nonnull OBOTermDefinition def) implements ProjectAction<SetOboTermDefinitionResult> {

    public static final String CHANNEL = "webprotege.obo.SetOboTermDefinition";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

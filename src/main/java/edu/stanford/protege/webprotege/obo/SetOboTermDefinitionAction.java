package edu.stanford.protege.webprotege.obo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import edu.stanford.protege.webprotege.common.ProjectId;
import org.semanticweb.owlapi.model.OWLEntity;

import javax.annotation.Nonnull;

import static com.google.common.base.MoreObjects.toStringHelper;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 22 Jun 2017
 */
public record SetOboTermDefinitionAction(@JsonProperty("projectId") @Nonnull ProjectId projectId,
                                        @Nonnull OWLEntity term,
                                        @JsonProperty("definition") @Nonnull OBOTermDefinition def) implements ProjectAction<SetOboTermDefinitionResult> {

}

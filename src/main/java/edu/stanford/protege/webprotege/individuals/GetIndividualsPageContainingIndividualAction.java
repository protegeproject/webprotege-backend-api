package edu.stanford.protege.webprotege.individuals;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLNamedIndividual;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Optional;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 19 Sep 2018
 */


@JsonTypeName("GetIndividualsPageContainingIndividual")
public record GetIndividualsPageContainingIndividualAction(@JsonProperty("projectId") @Nonnull ProjectId projectId,
                                                           @JsonProperty("individual") @Nonnull OWLNamedIndividual individual,
                                                           @JsonProperty("preferredType") @Nonnull Optional<OWLClass> preferredType,
                                                           @JsonProperty("preferredMode") @Nullable InstanceRetrievalMode preferredMode) implements ProjectAction<GetIndividualsPageContainingIndividualResult> {
}

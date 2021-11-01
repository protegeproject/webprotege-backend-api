package edu.stanford.protege.webprotege.individuals;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.dispatch.Result;
import edu.stanford.protege.webprotege.entity.EntityNode;
import edu.stanford.protege.webprotege.common.Page;
import org.semanticweb.owlapi.model.OWLNamedIndividual;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 19 Sep 2018
 */


@JsonTypeName("webprotege.entities.GetIndividualsPageContainingIndividual")
public record GetIndividualsPageContainingIndividualResult(@JsonProperty("individual") @Nonnull OWLNamedIndividual individual,
                                                           @JsonProperty("page") @Nonnull Page<EntityNode> page,
                                                           @JsonProperty("actualType") @Nonnull EntityNode actualType,
                                                           @JsonProperty("actualMode") @Nonnull InstanceRetrievalMode actualMode,
                                                           @JsonProperty("types") @Nonnull ImmutableSet<EntityNode> types) implements Result {

}

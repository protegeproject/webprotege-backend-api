package edu.stanford.protege.webprotege.hierarchy;

import com.fasterxml.jackson.annotation.*;
import edu.stanford.protege.webprotege.dispatch.Result;
import edu.stanford.protege.webprotege.entity.OWLEntityData;
import org.semanticweb.owlapi.model.OWLClass;

import javax.annotation.*;
import java.util.Set;

import static edu.stanford.protege.webprotege.hierarchy.GetClassHierarchyParentsByAxiomTypeAction.CHANNEL;


@JsonTypeName(CHANNEL)
public record GetClassHierarchyParentsByAxiomTypeResult(@JsonProperty("owlClass") @Nullable OWLClass owlClass,
                                                        @JsonProperty("parentsBySubclassOf") @Nonnull Set<OWLEntityData> parentsBySubclassOf,
                                                        @JsonProperty("parentsByEquivalentClass") @Nonnull Set<OWLEntityData> parentsByEquivalentClass) implements Result {
}

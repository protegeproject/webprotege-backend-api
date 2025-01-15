package edu.stanford.protege.webprotege.bulkop;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.dispatch.Result;
import edu.stanford.protege.webprotege.entity.OWLEntityData;

import javax.annotation.Nonnull;
import java.util.Optional;
import java.util.Set;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 25 Sep 2018
 */


@JsonTypeName("webprotege.entities.ChangeEntityParents")
public record ChangeEntityParentsResult(@JsonProperty("classesWithCycle") @Nonnull Set<OWLEntityData> classesWithCycle,
                                        @JsonProperty("classesWithRetiredParents") @Nonnull Set<OWLEntityData> classesWithRetiredParents,
                                        @JsonProperty("linearizationPathParent") Optional<OWLEntityData> linearizationPathParent) implements Result {

}
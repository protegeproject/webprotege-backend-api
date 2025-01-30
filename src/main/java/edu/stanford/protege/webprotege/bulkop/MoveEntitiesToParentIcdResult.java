package edu.stanford.protege.webprotege.bulkop;

import com.fasterxml.jackson.annotation.*;
import com.google.common.collect.*;
import edu.stanford.protege.webprotege.dispatch.Result;
import edu.stanford.protege.webprotege.entity.OWLEntityData;

import javax.annotation.Nonnull;

@JsonTypeName(MoveEntitiesToParentIcdAction.CHANNEL)
public record MoveEntitiesToParentIcdResult(
        @JsonProperty("isDestinationRetiredClass") boolean isDestinationRetiredClass,
        @JsonProperty("entitiesForWhichParentIsLinPathParent") @Nonnull ImmutableMap<String, ImmutableSet<OWLEntityData>> entitiesForWhichParentIsLinPathParent) implements Result {

    public static MoveEntitiesToParentIcdResult create(boolean isDestinationRetiredClass,
                                                       ImmutableMap<String, ImmutableSet<OWLEntityData>> entitiesForWhichParentIsLinPathParent) {
        return new MoveEntitiesToParentIcdResult(isDestinationRetiredClass, entitiesForWhichParentIsLinPathParent);
    }

}

package edu.stanford.protege.webprotege.perspective;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.dispatch.Result;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 18/02/16
 */


@JsonTypeName("GetPerspectivesResult")
public record GetPerspectivesResult(@JsonProperty("perspectives") @Nonnull ImmutableList<PerspectiveDescriptor> perspectives,
                                    @JsonProperty("resettablePerspectives") @Nonnull ImmutableSet<PerspectiveId> resettablePerspectives) implements Result {

}

package edu.stanford.protege.webprotege.viz;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.dispatch.Result;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 11 Oct 2018
 */


@JsonTypeName("GetEntityGraph")
public record GetEntityGraphResult(@JsonProperty("graph") @Nonnull EntityGraph entityGraph,
                                   @JsonProperty("settings") @Nonnull EntityGraphSettings settings) implements Result {

}

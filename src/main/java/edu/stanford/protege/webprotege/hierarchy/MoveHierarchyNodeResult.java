package edu.stanford.protege.webprotege.hierarchy;

import com.fasterxml.jackson.annotation.*;
import edu.stanford.protege.webprotege.dispatch.Result;

/**
 * Matthew Horridge Stanford Center for Biomedical Informatics Research 8 Dec 2017
 */


@JsonTypeName("webprotege.hierarchies.MoveHierarchyNode")
public record MoveHierarchyNodeResult(@JsonProperty("moved") boolean moved,
                                      @JsonProperty("isDestinationRetiredClass") boolean isDestinationRetiredClass) implements Result {

}

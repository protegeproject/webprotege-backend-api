package edu.stanford.protege.webprotege.hierarchy;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.dispatch.Result;

/**
 * Matthew Horridge Stanford Center for Biomedical Informatics Research 8 Dec 2017
 */


@JsonTypeName("MoveHierarchyNode")
public record MoveHierarchyNodeResult(@JsonProperty("moved") boolean moved) implements Result {

}

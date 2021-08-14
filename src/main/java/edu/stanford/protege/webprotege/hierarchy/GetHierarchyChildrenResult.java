package edu.stanford.protege.webprotege.hierarchy;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.dispatch.Result;
import edu.stanford.protege.webprotege.entity.EntityNode;
import edu.stanford.protege.webprotege.common.Page;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;


/**
 * Matthew Horridge Stanford Center for Biomedical Informatics Research 28 Nov 2017
 */

@JsonTypeName("GetHierarchyChildren")
public record GetHierarchyChildrenResult(@JsonProperty("parent") @Nullable GraphNode parent,
                                         @JsonProperty("children") @Nonnull Page<GraphNode<EntityNode>> children) implements Result {
}

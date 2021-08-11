package edu.stanford.protege.webprotege.hierarchy;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.dispatch.Result;
import edu.stanford.protege.webprotege.entity.EntityNode;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * Matthew Horridge Stanford Center for Biomedical Informatics Research 30 Nov 2017
 */


@JsonTypeName("GetHierarchyRoots")
public record GetHierarchyRootsResult(@JsonProperty("rootNodes") @Nonnull List<GraphNode<EntityNode>> rootNodes) implements Result {
}

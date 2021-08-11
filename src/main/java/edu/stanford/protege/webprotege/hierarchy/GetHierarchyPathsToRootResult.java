package edu.stanford.protege.webprotege.hierarchy;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.dispatch.Result;
import edu.stanford.protege.webprotege.entity.EntityNode;

import java.util.Collection;

/**
 * Matthew Horridge Stanford Center for Biomedical Informatics Research 28 Nov 2017
 */


@JsonTypeName("GetHierarchyPathsToRoot")
public record GetHierarchyPathsToRootResult(Collection<Path<GraphNode<EntityNode>>> paths) implements Result {

}

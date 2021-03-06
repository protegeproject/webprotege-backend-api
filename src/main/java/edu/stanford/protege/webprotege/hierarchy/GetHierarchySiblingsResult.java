package edu.stanford.protege.webprotege.hierarchy;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.dispatch.Result;
import edu.stanford.protege.webprotege.entity.EntityNode;
import edu.stanford.protege.webprotege.common.Page;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 13 Sep 2018
 */


@JsonTypeName("webprotege.hierarchies.GetHierarchySiblings")
public record GetHierarchySiblingsResult(Page<GraphNode<EntityNode>> siblingsPage) implements Result {

}

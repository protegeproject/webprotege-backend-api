package edu.stanford.protege.webprotege.hierarchy;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ChangeRequestId;
import edu.stanford.protege.webprotege.common.ContentChangeRequest;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import edu.stanford.protege.webprotege.entity.EntityNode;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge Stanford Center for Biomedical Informatics Research 8 Dec 2017
 */


@JsonTypeName("webprotege.hierarchies.MoveHierarchyNode")
public record MoveHierarchyNodeAction(@JsonProperty("changeRequestId") ChangeRequestId changeRequestId,
                                      @JsonProperty("projectId") @Nonnull ProjectId projectId,
                                      @JsonProperty("hierarchyDescriptor") @Nonnull HierarchyDescriptor hierarchyDescriptor,
                                      @JsonProperty("fromNodePath") @Nonnull Path<EntityNode> fromNodePath,
                                      @JsonProperty("toNodeParentPath") @Nonnull Path<EntityNode> toNodeParentPath,
                                      @JsonProperty("dropType") @Nonnull DropType dropType) implements ProjectAction<MoveHierarchyNodeResult>, ContentChangeRequest {

    public static final String CHANNEL = "webprotege.hierarchies.MoveHierarchyNode";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

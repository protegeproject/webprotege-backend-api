package edu.stanford.protege.webprotege.hierarchy;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ChangeRequestId;
import edu.stanford.protege.webprotege.common.ContentChangeRequest;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import edu.stanford.protege.webprotege.entity.EntityNode;

import javax.annotation.Nonnull;


@JsonTypeName(MoveHierarchyNodeIcdAction.CHANNEL)
public record MoveHierarchyNodeIcdAction(@JsonProperty("changeRequestId") ChangeRequestId changeRequestId,
                                         @JsonProperty("projectId") @Nonnull ProjectId projectId,
                                         @JsonProperty("hierarchyDescriptor") @Nonnull HierarchyDescriptor hierarchyDescriptor,
                                         @JsonProperty("fromNodePath") @Nonnull Path<EntityNode> fromNodePath,
                                         @JsonProperty("toNodeParentPath") @Nonnull Path<EntityNode> toNodeParentPath,
                                         @JsonProperty("dropType") @Nonnull DropType dropType) implements ProjectAction<MoveHierarchyNodeIcdResult>, ContentChangeRequest {

    public static final String CHANNEL = "webprotege.hierarchies.MoveHierarchyNodeIcd";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

package edu.stanford.protege.webprotege.hierarchy;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;

import javax.annotation.Nonnull;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge Stanford Center for Biomedical Informatics Research 30 Nov 2017
 */
@JsonTypeName("webprotege.hierarchies.GetHierarchyRoots")
public record GetHierarchyRootsAction(@Nonnull ProjectId projectId, @Nonnull HierarchyId hierarchyId) implements ProjectAction<GetHierarchyRootsResult> {

    public static final String CHANNEL = "webprotege.hierarchies.GetHierarchyRoots";

    @Override
    public String getChannel() {
        return CHANNEL;
    }

    public GetHierarchyRootsAction(@Nonnull ProjectId projectId, @Nonnull HierarchyId hierarchyId) {
        this.projectId = checkNotNull(projectId);
        this.hierarchyId = checkNotNull(hierarchyId);
    }
}

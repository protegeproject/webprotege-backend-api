package edu.stanford.protege.webprotege.hierarchy;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge Stanford Center for Biomedical Informatics Research 30 Nov 2017
 */
@JsonTypeName("GetHierarchyRoots")
public record GetHierarchyRootsAction(@Nonnull ProjectId projectId, @Nonnull HierarchyId hierarchyId) implements ProjectAction<GetHierarchyRootsResult> {

    public static final String CHANNEL = "webprotege.hierarchies.GetHierarchyRoots";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

package edu.stanford.protege.webprotege.hierarchy;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import org.semanticweb.owlapi.model.OWLEntity;

import javax.annotation.Nonnull;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge Stanford Center for Biomedical Informatics Research 28 Nov 2017
 */


@JsonTypeName("webprotege.hierarchies.GetHierarchyPathsToRoot")
public record GetHierarchyPathsToRootAction(@JsonProperty("projectId") @Nonnull ProjectId projectId,
                                            @JsonProperty("entity") @Nonnull OWLEntity entity,
                                            @JsonProperty("hierarchyId") @Nonnull HierarchyId hierarchyId) implements ProjectAction<GetHierarchyPathsToRootResult> {

    public static final String CHANNEL = "webprotege.hierarchies.GetHierarchyPathsToRoot";

    @Override
    public String getChannel() {
        return CHANNEL;
    }

    public GetHierarchyPathsToRootAction(@JsonProperty("projectId") @Nonnull ProjectId projectId,
                                         @JsonProperty("entity") @Nonnull OWLEntity entity,
                                         @JsonProperty("hierarchyId") @Nonnull HierarchyId hierarchyId) {
        this.projectId = checkNotNull(projectId);
        this.entity = checkNotNull(entity);
        this.hierarchyId = checkNotNull(hierarchyId);
    }
}

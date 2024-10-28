package edu.stanford.protege.webprotege.hierarchy;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.PageRequest;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import org.semanticweb.owlapi.model.OWLEntity;

import javax.annotation.Nonnull;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge Stanford Center for Biomedical Informatics Research 28 Nov 2017
 */


@JsonTypeName("webprotege.hierarchies.GetHierarchyChildren")
public record GetHierarchyChildrenAction(@JsonProperty("projectId") @Nonnull ProjectId projectId,
                                         @JsonProperty("entity") @Nonnull OWLEntity entity,
                                         @JsonProperty("hierarchyDescriptor") @Nonnull HierarchyDescriptor hierarchyDescriptor,
                                         @JsonProperty("pageRequest") @Nonnull PageRequest pageRequest) implements ProjectAction<GetHierarchyChildrenResult> {

    public static final String CHANNEL = "webprotege.hierarchies.GetHierarchyChildren";

    @Override
    public String getChannel() {
        return CHANNEL;
    }

    public GetHierarchyChildrenAction(@JsonProperty("projectId") @Nonnull ProjectId projectId,
                                      @JsonProperty("entity") @Nonnull OWLEntity entity,
                                      @JsonProperty("hierarchyDescriptor") @Nonnull HierarchyDescriptor hierarchyDescriptor,
                                      @JsonProperty("pageRequest") @Nonnull PageRequest pageRequest) {
        this.projectId = checkNotNull(projectId);
        this.entity = checkNotNull(entity);
        this.hierarchyDescriptor = checkNotNull(hierarchyDescriptor);
        this.pageRequest = checkNotNull(pageRequest);
    }
}

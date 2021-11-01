package edu.stanford.protege.webprotege.viz;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;

import javax.annotation.Nonnull;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2019-12-07
 */
@JsonTypeName("webprotege.graphs.GetProjectEntityGraphDefaultEdgeCriteria")
public record GetProjectEntityGraphDefaultEdgeCriteriaAction(ProjectId projectId) implements ProjectAction<GetProjectEntityGraphDefaultEdgeCriteriaResult> {

    public static final String CHANNEL = "webprotege.graphs.GetProjectEntityGraphDefaultEdgeCriteria";

    public GetProjectEntityGraphDefaultEdgeCriteriaAction(@Nonnull ProjectId projectId) {
        this.projectId = checkNotNull(projectId);
    }

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

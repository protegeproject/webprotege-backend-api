package edu.stanford.protege.webprotege.viz;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2019-12-10
 */


@JsonTypeName("GetUserProjectEntityGraphCriteria")
public record GetUserProjectEntityGraphCriteriaAction(@JsonProperty("projectId") @Nonnull ProjectId projectId) implements ProjectAction<GetUserProjectEntityGraphCriteriaResult> {

    public static final String CHANNEL = "webprotege.graph.GetUserProjectEntityGraphCriteria";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

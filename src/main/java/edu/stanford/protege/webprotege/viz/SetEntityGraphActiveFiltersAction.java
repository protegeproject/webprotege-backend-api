package edu.stanford.protege.webprotege.viz;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.common.ChangeRequest;
import edu.stanford.protege.webprotege.common.ChangeRequestId;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2019-12-14
 */


@JsonTypeName("webprotege.graphs.SetEntityGraphActiveFilters")
public record SetEntityGraphActiveFiltersAction(@JsonProperty("changeRequestId") ChangeRequestId changeRequestId,
                                                @JsonProperty("projectId") @Nonnull ProjectId projectId,
                                                @JsonProperty("activeFilters") @Nonnull ImmutableList<FilterName> activeFilters) implements ProjectAction<SetEntityGraphActiveFiltersResult>, ChangeRequest {

    public static final String CHANNEL = "webprotege.graphs.SetEntityGraphActiveFilters";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

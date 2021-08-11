package edu.stanford.protege.webprotege.viz;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2019-12-14
 */


@JsonTypeName("SetEntityGraphActiveFilters")
public record SetEntityGraphActiveFiltersAction(@JsonProperty("projectId") @Nonnull ProjectId projectId,
                                                @JsonProperty("activeFilters") @Nonnull ImmutableList<FilterName> activeFilters) implements ProjectAction<SetEntityGraphActiveFiltersResult> {

}

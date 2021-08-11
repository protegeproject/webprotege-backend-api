package edu.stanford.protege.webprotege.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2020-08-17
 */


@JsonTypeName("SetSearchSettings")
public record SetSearchSettingsAction(@JsonProperty("projectId") @Nonnull ProjectId projectId,
                                      @JsonProperty("from") @Nonnull ImmutableList<EntitySearchFilter> from,
                                      @JsonProperty("to") @Nonnull ImmutableList<EntitySearchFilter> to) implements ProjectAction<SetSearchSettingsResult> {
}

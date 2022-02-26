package edu.stanford.protege.webprotege.search;

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
 * 2020-08-17
 */


@JsonTypeName("webprotege.search.SetSearchSettings")
public record SetSearchSettingsAction(@JsonProperty("changeRequestId") ChangeRequestId changeRequestId,
                                      @JsonProperty("projectId") @Nonnull ProjectId projectId,
                                      @JsonProperty("from") @Nonnull ImmutableList<EntitySearchFilter> from,
                                      @JsonProperty("to") @Nonnull ImmutableList<EntitySearchFilter> to) implements ProjectAction<SetSearchSettingsResult>, ChangeRequest {

    public static final String CHANNEL = "webprotege.search.SetSearchSettings";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

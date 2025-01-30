package edu.stanford.protege.webprotege.perspective;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.common.ChangeRequest;
import edu.stanford.protege.webprotege.common.ChangeRequestId;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.UserId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Optional;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 18/02/16
 */


@JsonTypeName("webprotege.perspectives.SetPerspectives")
public record SetPerspectivesAction(@Nonnull @JsonProperty("changeRequestId") ChangeRequestId changeRequestId,
                                    @Nonnull @JsonProperty("projectId") ProjectId projectId,
                                    @Nullable @JsonProperty("userId") UserId userId,
                                    @Nonnull @JsonProperty("perspectives") ImmutableList<PerspectiveDescriptor> perspectives) implements ProjectAction<SetPerspectivesResult>, ChangeRequest {

    public static final String CHANNEL = "webprotege.perspectives.SetPerspectives";

    @JsonIgnore
    public Optional<UserId> getUserId() {
        return Optional.ofNullable(userId);
    }

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}


package edu.stanford.protege.webprotege.viz;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ChangeRequest;
import edu.stanford.protege.webprotege.common.ChangeRequestId;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import edu.stanford.protege.webprotege.common.UserId;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Optional;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2019-12-10
 */


@JsonTypeName("webprotege.graphs.SetUserProjectEntityGraphSettings")
public record SetUserProjectEntityGraphSettingsAction(@JsonProperty("changeRequestId") ChangeRequestId changeRequestId,
                                                      @JsonProperty("projectId") @Nonnull ProjectId projectId,
                                                      @JsonProperty("userId") @Nullable UserId userId,
                                                      @JsonProperty("settings") @Nonnull EntityGraphSettings settings) implements ProjectAction<SetUserProjectEntityGraphSettingsResult>, ChangeRequest {

    public static final String CHANNEL = "webprotege.graphs.SetUserProjectEntityGraphSettings";

    @Nonnull
    public Optional<UserId> getUserId() {
        return Optional.ofNullable(userId);
    }

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

package edu.stanford.protege.webprotege.issues.events;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.base.Objects;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.UserId;

import javax.annotation.Nonnull;

import static com.google.common.base.MoreObjects.toStringHelper;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 26 Sep 16
 */
@JsonTypeName("IssueRenamedEvent")
public record IssueRenamedEvent(@Nonnull ProjectId projectId, @Nonnull UserId userId, long timestamp, @Nonnull String from, @Nonnull String to) implements IssueEvent {

    public static final String CHANNEL = "webprotege.issues.event.IssueRenamed";

    @Override
    public String getChannel() {
        return CHANNEL;
    }

    public IssueRenamedEvent(@Nonnull ProjectId projectId,
                             @Nonnull UserId userId,
                             long timestamp,
                             @Nonnull String from,
                             @Nonnull String to) {
        this.projectId = checkNotNull(projectId);
        this.userId = checkNotNull(userId);
        this.timestamp = timestamp;
        this.from = checkNotNull(from);
        this.to = checkNotNull(to);
    }
}

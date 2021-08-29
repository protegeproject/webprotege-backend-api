package edu.stanford.protege.webprotege.issues.events;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.base.Objects;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.issues.Milestone;
import edu.stanford.protege.webprotege.common.UserId;

import javax.annotation.Nonnull;

import static com.google.common.base.MoreObjects.toStringHelper;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 26 Sep 16
 */
@JsonTypeName("IssueMilestonedEvent")
public record IssueMilestonedEvent(@Nonnull ProjectId projectId, @Nonnull UserId userId, long timestamp, @Nonnull Milestone milestone) implements IssueEvent {

    public static final String CHANNEL = "webprotege.issues.event.IssueMilestoned";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

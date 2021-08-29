package edu.stanford.protege.webprotege.issues.events;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.base.Objects;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.UserId;

import javax.annotation.Nonnull;

import static com.google.common.base.MoreObjects.toStringHelper;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 26 Sep 16
 */
@JsonTypeName("IssueReferencedEvent")
public record IssueReferencedEvent(@Nonnull ProjectId projectId, @Nonnull UserId userId,
                                   long timestamp,
                                   int issueNumber, int referencedByIssueNumber) implements IssueEvent {

    public static final String CHANNEL = "webprotege.issues.event.IssueReferenced";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

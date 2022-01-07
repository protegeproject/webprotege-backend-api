package edu.stanford.protege.webprotege.issues.events;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.base.Objects;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.UserId;
import org.semanticweb.owlapi.model.OWLEntity;

import javax.annotation.Nonnull;

import static com.google.common.base.MoreObjects.toStringHelper;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 29 Sep 2016
 */
@JsonTypeName("webprotege.issues.event.IssueTargetAdded")
public record IssueTargetAddedEvent(@Nonnull ProjectId projectId, @Nonnull UserId userId, long timestamp, @Nonnull OWLEntity targetEntity) implements IssueEvent {

    public static final String CHANNEL = "webprotege.issues.event.IssueTargetAdded";

    @Override
    public String getChannel() {
        return CHANNEL;
    }

    public IssueTargetAddedEvent(@Nonnull ProjectId projectId,
                                 @Nonnull UserId userId,
                                 long timestamp,
                                 @Nonnull OWLEntity targetEntity) {
        this.projectId = checkNotNull(projectId);
        this.userId = checkNotNull(userId);
        this.timestamp = timestamp;
        this.targetEntity = checkNotNull(targetEntity);
    }
}

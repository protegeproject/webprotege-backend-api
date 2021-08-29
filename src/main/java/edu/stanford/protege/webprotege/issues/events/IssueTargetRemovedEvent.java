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
@JsonTypeName("IssueTargetRemovedEvent")
public record IssueTargetRemovedEvent(@Nonnull ProjectId projectId, @Nonnull UserId userId, long timestamp, @Nonnull OWLEntity entity) implements IssueEvent {

    public static final String CHANNEL = "webprotege.issues.event.IssueTargetRemoved";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

package edu.stanford.protege.webprotege.tag;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.EventId;
import edu.stanford.protege.webprotege.common.ProjectEvent;
import edu.stanford.protege.webprotege.common.ProjectId;
import org.semanticweb.owlapi.model.OWLEntity;

import javax.annotation.Nonnull;
import java.util.Collection;

import static com.google.common.base.Preconditions.checkNotNull;


/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 22 Mar 2018
 */
@JsonTypeName("webprotege.events.tags.EntityTagsChanged")
public record EntityTagsChangedEvent(@Nonnull EventId eventId,
                                     @Nonnull ProjectId projectId,
                                    @Nonnull OWLEntity entity,
                                    @Nonnull Collection<Tag> tags) implements ProjectEvent {

    public static final String CHANNEL = "webprotege.events.tags.EntityTagsChanged";

    @Override
    public String getChannel() {
        return CHANNEL;
    }

    public EntityTagsChangedEvent(EventId eventId,
                                  @Nonnull ProjectId projectId,
                                  @Nonnull OWLEntity entity,
                                  @Nonnull Collection<Tag> tags) {
        this.eventId = checkNotNull(eventId);
        this.projectId = checkNotNull(projectId);
        this.entity = checkNotNull(entity);
        this.tags = checkNotNull(tags);
    }
}

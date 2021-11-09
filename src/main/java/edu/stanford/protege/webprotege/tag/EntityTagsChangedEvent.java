package edu.stanford.protege.webprotege.tag;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.common.Event;
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
@JsonTypeName("EntityTagsChangedEvent")
public record EntityTagsChangedEvent(@Nonnull ProjectId projectId,
                                    @Nonnull OWLEntity entity,
                                    @Nonnull Collection<Tag> tags) implements ProjectEvent {

    public static final String CHANNEL = "webprotege.tags.events.EntityTagsChanged";

    @Override
    public String getChannel() {
        return CHANNEL;
    }

    public EntityTagsChangedEvent(@Nonnull ProjectId projectId,
                                  @Nonnull OWLEntity entity,
                                  @Nonnull Collection<Tag> tags) {
        this.projectId = checkNotNull(projectId);
        this.entity = checkNotNull(entity);
        this.tags = checkNotNull(tags);
    }
}

package edu.stanford.protege.webprotege.tag;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.event.ProjectEvent;
import org.semanticweb.owlapi.model.OWLEntity;

import javax.annotation.Nonnull;
import java.util.Collection;

import static com.google.common.base.MoreObjects.toStringHelper;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 22 Mar 2018
 */
public class EntityTagsChangedEvent extends ProjectEvent {

    private OWLEntity entity;

    private ImmutableSet<Tag> tags;

    public EntityTagsChangedEvent(@Nonnull ProjectId projectId,
                                  @Nonnull OWLEntity entity,
                                  @Nonnull Collection<Tag> tags) {
        super(checkNotNull(projectId));
        this.entity = checkNotNull(entity);
        this.tags = ImmutableSet.copyOf(checkNotNull(tags));
    }


    private EntityTagsChangedEvent() {
    }

    @Nonnull
    public OWLEntity getEntity() {
        return entity;
    }

    @Nonnull
    public Collection<Tag> getTags() {
        return tags;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(projectId(), entity, tags);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EntityTagsChangedEvent)) {
            return false;
        }
        EntityTagsChangedEvent other = (EntityTagsChangedEvent) obj;
        return this.projectId().equals(other.projectId())
                && this.entity.equals(other.entity)
                && this.tags.equals(other.tags);
    }


    @Override
    public String toString() {
        return toStringHelper("EntityTagsChangedEvent")
                .addValue(projectId())
                .addValue(entity)
                .addValue(tags)
                .toString();
    }
}

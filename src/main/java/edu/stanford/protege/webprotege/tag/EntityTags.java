package edu.stanford.protege.webprotege.tag;

import edu.stanford.protege.webprotege.common.ProjectId;
import org.semanticweb.owlapi.model.OWLEntity;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.google.common.base.MoreObjects.toStringHelper;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 15 Mar 2018
 */
public class EntityTags {

    public static final String PROJECT_ID = "projectId";

    public static final String ENTITY = "entity";

    public static final String TAGS = "tags";

    private final ProjectId projectId;

    private final OWLEntity entity;

    private final List<TagId> tags;


    public EntityTags(@Nonnull ProjectId projectId, @Nonnull OWLEntity entity, @Nonnull List<TagId> tags) {
        this.projectId = checkNotNull(projectId);
        this.entity = checkNotNull(entity);
        this.tags = new ArrayList<>(checkNotNull(tags));
    }

    @Nonnull
    public ProjectId getProjectId() {
        return projectId;
    }

    @Nonnull
    public OWLEntity getEntity() {
        return entity;
    }

    @Nonnull
    public List<TagId> getTags() {
        return new ArrayList<>(tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId, entity, tags);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EntityTags)) {
            return false;
        }
        EntityTags other = (EntityTags) obj;
        return this.entity.equals(other.entity) && this.projectId.equals(other.projectId) && this.tags.equals(other.tags);
    }


    @Override
    public String toString() {
        return toStringHelper("EntityTags").addValue(projectId).addValue(entity).addValue(tags).toString();
    }
}

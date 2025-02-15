package edu.stanford.protege.webprotege.perspective;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.auto.value.AutoValue;
import edu.stanford.protege.webprotege.common.UUIDUtil;

import javax.annotation.Nonnull;
import java.io.Serializable;
import java.util.UUID;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 12/02/16
 */
@AutoValue

public abstract class PerspectiveId implements  Serializable {

    @JsonCreator
    @Nonnull
    public static PerspectiveId get(@Nonnull String id) {
        if(!UUIDUtil.isWellFormed(id)) {
            throw new IllegalArgumentException("Malformed PerspectiveId.  PerspectiveIds must be UUIDs");
        }
        return new AutoValue_PerspectiveId(id);
    }

    /**
     * Generates a fresh {@link PerspectiveId} using a randomly generated UUID.
     * @return The newly generated {@link PerspectiveId}.
     */
    @Nonnull
    public static PerspectiveId generate() {
        return get(UUID.randomUUID().toString());
    }

    /**
     * Gets the identifier for this perspective.  This is a human readable name.
     */
    @JsonValue
    @Nonnull
    public abstract String getId();

    @JsonIgnore
    public String value() {
        return getId();
    }
}

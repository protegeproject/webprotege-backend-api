package edu.stanford.protege.webprotege.entity;

import com.fasterxml.jackson.annotation.*;
import com.google.auto.value.AutoValue;

import javax.annotation.Nonnull;
import java.io.Serializable;

@AutoValue
public abstract class EntityStatus implements Serializable, Comparable<EntityStatus> {

    @JsonCreator
    public static EntityStatus get(@Nonnull @JsonProperty("status") String status) {
        return new AutoValue_EntityStatus(status);
    }


    @JsonProperty("status")
    @Nonnull
    public abstract String getStatus();


    @Override
    public int compareTo(EntityStatus o) {
        return this.getStatus().compareToIgnoreCase(o.getStatus());
    }
}

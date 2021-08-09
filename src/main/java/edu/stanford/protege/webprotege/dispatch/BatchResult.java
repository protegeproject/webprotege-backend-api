package edu.stanford.protege.webprotege.dispatch;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableList;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 27 Oct 2018
 */
@AutoValue

@JsonTypeName("Batch")
public abstract class BatchResult implements Result {

    @JsonCreator
    @Nonnull
    public static BatchResult get(@JsonProperty("results") @Nonnull ImmutableList<Result> results) {
        return new AutoValue_BatchResult(results);
    }

    @Nonnull
    public abstract ImmutableList<Result> getResults();
}

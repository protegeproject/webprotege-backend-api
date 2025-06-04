package edu.stanford.protege.webprotege.issues;

import com.fasterxml.jackson.annotation.*;
import edu.stanford.protege.webprotege.dispatch.Result;

import javax.annotation.Nullable;

import static edu.stanford.protege.webprotege.issues.GetEntityEarliestCommentTimestampAction.CHANNEL;


@JsonTypeName(CHANNEL)
public record GetEntityEarliestCommentTimestampResult(
        @JsonProperty("earliestTimestamp") Long earliestTimestamp
) implements Result {

    @JsonCreator
    public static GetEntityEarliestCommentTimestampResult create(@JsonProperty("earliestTimestamp") @Nullable Long earliestTimestamp) {
        return new GetEntityEarliestCommentTimestampResult(earliestTimestamp);
    }
}

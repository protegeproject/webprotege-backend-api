package edu.stanford.protege.webprotege.issues;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.dispatch.Result;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 6 Oct 2016
 */
@JsonTypeName("webprotege.discussions.CreateEntityDiscussionThread")
public record CreateEntityDiscussionThreadResult(@Nonnull ImmutableList<EntityDiscussionThread> threads) implements Result {
}

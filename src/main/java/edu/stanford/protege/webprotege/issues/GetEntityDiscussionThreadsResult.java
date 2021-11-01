package edu.stanford.protege.webprotege.issues;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.dispatch.Result;
import edu.stanford.protege.webprotege.entity.OWLEntityData;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 5 Oct 2016
 */


@JsonTypeName("webprotege.discussions.GetEntityDiscussionThreads")
public record GetEntityDiscussionThreadsResult(OWLEntityData entity,
                                               ImmutableList<EntityDiscussionThread> threads) implements Result {
}

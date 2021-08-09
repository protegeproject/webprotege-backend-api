package edu.stanford.protege.webprotege.issues;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.dispatch.Result;
import edu.stanford.protege.webprotege.event.EventList;
import edu.stanford.protege.webprotege.event.HasEventList;
import edu.stanford.protege.webprotege.event.ProjectEvent;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 6 Oct 2016
 */
@AutoValue

@JsonTypeName("CreateEntityDiscussionThread")
public abstract class CreateEntityDiscussionThreadResult implements Result, HasEventList<ProjectEvent> {

    @JsonCreator
    public static CreateEntityDiscussionThreadResult create(@JsonProperty("threads") @Nonnull ImmutableList<EntityDiscussionThread> threads,
                                              @JsonProperty("eventList") @Nonnull EventList<ProjectEvent> eventList) {
        return new AutoValue_CreateEntityDiscussionThreadResult(threads, eventList);
    }

    public abstract ImmutableList<EntityDiscussionThread> getThreads();

    @Override
    public abstract EventList<ProjectEvent> getEventList();
}

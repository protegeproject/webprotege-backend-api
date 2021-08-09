package edu.stanford.protege.webprotege.entity;

import com.google.common.base.Objects;
import edu.stanford.protege.webprotege.dispatch.Result;
import edu.stanford.protege.webprotege.event.EventList;
import edu.stanford.protege.webprotege.event.HasEventList;
import edu.stanford.protege.webprotege.event.ProjectEvent;

import javax.annotation.Nonnull;

import static com.google.common.base.MoreObjects.toStringHelper;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 9 Mar 2018
 */
public class MergeEntitiesResult implements Result, HasEventList<ProjectEvent> {

    private EventList<ProjectEvent> eventList;

    private MergeEntitiesResult(@Nonnull EventList<ProjectEvent> eventList) {
        this.eventList = checkNotNull(eventList);
    }


    private MergeEntitiesResult() {
    }

    public static MergeEntitiesResult create(@Nonnull EventList<ProjectEvent> eventList) {
        return new MergeEntitiesResult(eventList);
    }

    @Override
    public EventList<ProjectEvent> getEventList() {
        return eventList;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(eventList);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MergeEntitiesResult)) {
            return false;
        }
        MergeEntitiesResult other = (MergeEntitiesResult) obj;
        return this.eventList.equals(other.eventList);
    }


    @Override
    public String toString() {
        return toStringHelper("MergeEntitiesResult")
                .toString();
    }
}

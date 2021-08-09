package edu.stanford.protege.webprotege.watches;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import edu.stanford.protege.webprotege.dispatch.Result;
import edu.stanford.protege.webprotege.event.EventList;
import edu.stanford.protege.webprotege.event.HasEventList;
import edu.stanford.protege.webprotege.event.ProjectEvent;

import java.util.Objects;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 20/03/2013
 */
public class AddWatchResult implements Result, HasEventList<ProjectEvent> {

    private EventList<ProjectEvent> eventList;

    private AddWatchResult() {
    }

    @JsonCreator
    public AddWatchResult(@JsonProperty("eventList") EventList<ProjectEvent> eventList) {
        this.eventList = checkNotNull(eventList);
    }

    @Override
    public EventList<ProjectEvent> getEventList() {
        return eventList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AddWatchResult)) {
            return false;
        }
        AddWatchResult that = (AddWatchResult) o;
        return Objects.equals(eventList, that.eventList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventList);
    }
}

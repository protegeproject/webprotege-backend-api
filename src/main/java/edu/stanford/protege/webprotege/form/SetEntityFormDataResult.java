package edu.stanford.protege.webprotege.form;


import edu.stanford.protege.webprotege.dispatch.Result;
import edu.stanford.protege.webprotege.event.EventList;
import edu.stanford.protege.webprotege.event.HasEventList;
import edu.stanford.protege.webprotege.event.ProjectEvent;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2019-11-01
 */
public class SetEntityFormDataResult implements Result, HasEventList<ProjectEvent> {

    private EventList<ProjectEvent> eventList;

    public SetEntityFormDataResult(EventList<ProjectEvent> eventList) {
        this.eventList = checkNotNull(eventList);
    }


    private SetEntityFormDataResult() {
    }

    @Override
    public EventList<ProjectEvent> getEventList() {
        return eventList;
    }
}

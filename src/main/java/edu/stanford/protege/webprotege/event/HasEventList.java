package edu.stanford.protege.webprotege.event;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 20/03/2013
 */
public interface HasEventList<T extends WebProtegeEvent> {

    EventList eventList();

}

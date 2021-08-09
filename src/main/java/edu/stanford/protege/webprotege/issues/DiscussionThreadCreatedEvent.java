package edu.stanford.protege.webprotege.issues;



import edu.stanford.protege.webprotege.event.ProjectEvent;
import edu.stanford.protege.webprotege.project.HasProjectId;

import java.util.Objects;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 12 Oct 2016
 */
public class DiscussionThreadCreatedEvent extends ProjectEvent implements HasProjectId {

    private EntityDiscussionThread thread;

    public DiscussionThreadCreatedEvent(EntityDiscussionThread thread) {
        super(thread.getProjectId());
        this.thread = thread;
    }


    private DiscussionThreadCreatedEvent() {
    }

    public EntityDiscussionThread getThread() {
        return thread;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DiscussionThreadCreatedEvent)) {
            return false;
        }
        DiscussionThreadCreatedEvent that = (DiscussionThreadCreatedEvent) o;
        return Objects.equals(thread, that.thread) && Objects.equals(getProjectId(), ((DiscussionThreadCreatedEvent) o).getProjectId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(thread, getProjectId());
    }
}

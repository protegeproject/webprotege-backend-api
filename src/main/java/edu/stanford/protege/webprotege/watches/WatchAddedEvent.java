package edu.stanford.protege.webprotege.watches;


import edu.stanford.protege.webprotege.event.ProjectEvent;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.user.UserId;

import java.util.Objects;

import static com.google.common.base.MoreObjects.toStringHelper;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 21/03/2013
 */
public class WatchAddedEvent extends ProjectEvent {

    private Watch watch;

    /**
     * For serialization only.
     */
    private WatchAddedEvent() {
    }

    /**
     * Creates a {@link WatchAddedEvent}.
     * @param source The id of the project that the watch was added to.  Not {@code null}.
     * @param watch The watch that was added.  Not {@code null}.
     */
    public WatchAddedEvent(ProjectId source, Watch watch) {
        super(source);
        this.watch = watch;
    }

    public Watch getWatch() {
        return watch;
    }

    public UserId getUserId() {
        return watch.getUserId();
    }


    @Override
    public String toString() {
        return toStringHelper("WatchAddedEvent")
                .addValue(getProjectId())
                .addValue(getWatch())
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WatchAddedEvent)) {
            return false;
        }
        WatchAddedEvent that = (WatchAddedEvent) o;
        return Objects.equals(watch, that.watch);
    }

    @Override
    public int hashCode() {
        return Objects.hash(watch);
    }
}

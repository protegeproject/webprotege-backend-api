package edu.stanford.protege.webprotege.event;


import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.Event;
import edu.stanford.protege.webprotege.common.ProjectEvent;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.project.HasProjectId;

import javax.annotation.Nonnull;
import java.util.Objects;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 09/04/2013
 */
@JsonTypeName("ProjectMovedToTrashEvent")
public record ProjectMovedToTrashEvent(ProjectId projectId) implements ProjectEvent {

    public static final String CHANNEL = "webprotege.projects.events.ProjectMovedToTrash";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

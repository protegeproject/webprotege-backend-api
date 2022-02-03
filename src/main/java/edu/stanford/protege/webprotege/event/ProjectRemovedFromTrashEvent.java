package edu.stanford.protege.webprotege.event;


import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.Event;
import edu.stanford.protege.webprotege.common.ProjectEvent;
import edu.stanford.protege.webprotege.common.ProjectId;

import java.util.Objects;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 09/04/2013
 */
@JsonTypeName("webprotege.events.projects.ProjectRemovedFromTrash")
public record ProjectRemovedFromTrashEvent(ProjectId projectId) implements ProjectEvent {

    public static final String CHANNEL = "webprotege.events.projects.ProjectRemovedFromTrash";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

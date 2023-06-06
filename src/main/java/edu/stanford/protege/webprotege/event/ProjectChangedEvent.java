package edu.stanford.protege.webprotege.event;


import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.EventId;
import edu.stanford.protege.webprotege.common.ProjectEvent;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.entity.OWLEntityData;
import edu.stanford.protege.webprotege.revision.RevisionSummary;

import java.util.Set;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 26/03/2013
 *
 * Creates a {@link ProjectChangedEvent}.
 * @param projectId The source of the event.  The project that was changed.  Not {@code null}.
 * @param revisionSummary The summary of the revision to the project.  Not {@code null}.
 * @param subjects The possibly empty set of subjects of the changes.  Not {@code null}.
 * @throws NullPointerException if any parameters are {@code null}.
 */
@JsonTypeName("webprotege.events.project.ProjectChanged")
public record ProjectChangedEvent(EventId eventId,
                                  ProjectId projectId, RevisionSummary revisionSummary, Set<OWLEntityData> subjects) implements ProjectEvent {

    public static final String CHANNEL = "webprotege.events.project.ProjectChanged";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

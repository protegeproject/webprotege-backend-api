package edu.stanford.protege.webprotege.event;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.base.MoreObjects;
import edu.stanford.protege.webprotege.common.Event;
import edu.stanford.protege.webprotege.common.ProjectEvent;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.entity.OWLEntityData;
import edu.stanford.protege.webprotege.revision.RevisionNumber;
import edu.stanford.protege.webprotege.revision.RevisionSummary;
import edu.stanford.protege.webprotege.common.UserId;
import org.semanticweb.owlapi.model.OWLEntity;

import java.util.HashSet;
import java.util.Set;

import static com.google.common.base.Preconditions.checkNotNull;

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
public record ProjectChangedEvent(ProjectId projectId, RevisionSummary revisionSummary, Set<OWLEntityData> subjects) implements ProjectEvent {

    public static final String CHANNEL = "webprotege.events.project.ProjectChanged";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

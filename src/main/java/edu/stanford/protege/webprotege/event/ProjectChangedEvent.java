package edu.stanford.protege.webprotege.event;


import com.google.common.base.MoreObjects;
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
 */
public class ProjectChangedEvent extends ProjectEvent {

    private Set<OWLEntityData> subjects;

    private RevisionSummary revisionSummary;

    /**
     * For serialization purposes only.
     */
    private ProjectChangedEvent() {
    }

    /**
     * Creates a {@link ProjectChangedEvent}.
     * @param source The source of the event.  The project that was changed.  Not {@code null}.
     * @param revisionSummary The summary of the revision to the project.  Not {@code null}.
     * @param subjects The possibly empty set of subjects of the changes.  Not {@code null}.
     * @throws NullPointerException if any parameters are {@code null}.
     */
    public ProjectChangedEvent(ProjectId source, RevisionSummary revisionSummary, Set<OWLEntityData> subjects) {
        super(source);
        this.revisionSummary = checkNotNull(revisionSummary);
        this.subjects = new HashSet<OWLEntityData>(subjects);
    }

    /**
     * Gets the revision summary for this event.
     * @return The {@link RevisionSummary}.  Not {@code null}.
     */
    public RevisionSummary getRevisionSummary() {
        return revisionSummary;
    }

    /**
     * Gets the {@link RevisionNumber} of the project after the changes were applied.
     * @return The {@link RevisionNumber}.  Not {@code null}.
     */
    public RevisionNumber getRevisionNumber() {
        return revisionSummary.getRevisionNumber();
    }

    /**
     * Gets the {@link UserId} of the user that caused the changes to be applied.
     * @return The {@link UserId} of the user.  Not {@code null}.
     */
    public UserId getUserId() {
        return revisionSummary.getUserId();
    }

    /**
     * Gets the timestamp that represents the time the changes were applied.
     * @return The timestamp.
     */
    public long getTimestamp() {
        return revisionSummary.getTimestamp();
    }

    /**
     * Gets the subjects of the changes.
     * @return A possibly empty set of {@link OWLEntity} objects which represent the subject of the changes.  Not {@code null}.
     */
    public Set<OWLEntityData> getSubjects() {
        return new HashSet<OWLEntityData>(subjects);
    }


    @Override
    public int hashCode() {
        return "ProjectChangedEvent".hashCode() + subjects.hashCode() + revisionSummary.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof ProjectChangedEvent)) {
            return false;
        }
        ProjectChangedEvent other = (ProjectChangedEvent) obj;
        return this.subjects.equals(other.subjects) && this.revisionSummary.equals(other.revisionSummary);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper("ProjectChangedEvent")
                          .add("subjects", subjects)
                          .add("revisionSummary", revisionSummary).toString();
    }
}

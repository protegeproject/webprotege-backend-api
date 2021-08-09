package edu.stanford.protege.webprotege.event;



import edu.stanford.protege.webprotege.common.ProjectId;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2020-11-04
 */
public class LargeNumberOfChangesEvent extends ProjectEvent {

    public LargeNumberOfChangesEvent(ProjectId source) {
        super(source);
    }


    private LargeNumberOfChangesEvent() {
    }

    @Override
    public int hashCode() {
        return getProjectId().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof LargeNumberOfChangesEvent)) {
            return false;
        }
        LargeNumberOfChangesEvent other = (LargeNumberOfChangesEvent) obj;
        return this.getProjectId().equals(other.getProjectId());
    }
}

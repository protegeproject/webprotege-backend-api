package edu.stanford.protege.webprotege.event;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import edu.stanford.protege.webprotege.project.ProjectId;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 20/03/2013
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "eventType")
public abstract class WebProtegeEvent {

    private ProjectId projectId;

    protected WebProtegeEvent() {
    }

    public ProjectId getSource() {
        return projectId;
    }

    protected void setSource(ProjectId source) {
        this.projectId = source;
    }
}

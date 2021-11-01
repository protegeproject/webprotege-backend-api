package edu.stanford.protege.webprotege.project;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.dispatch.Action;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 01/04/2013
 */
@JsonTypeName("webprotege.projects.GetAvailableProjects")
@JsonClassDescription("Gets the available projects for the authenticated user.  " +
        "An available project is a project that can be opened in WebProtégé.")
public record GetAvailableProjectsAction() implements Action<GetAvailableProjectsResult> {

    public static final String CHANNEL = "webprotege.projects.GetAvailableProjects";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

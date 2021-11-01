package edu.stanford.protege.webprotege.project;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.dispatch.Result;

import java.util.List;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 01/04/2013
 */


@JsonTypeName("webprotege.projects.GetAvailableProjects")
public record GetAvailableProjectsResult(@JsonProperty("availableProjects") List<AvailableProject> availableProjects) implements Result {

}

package edu.stanford.protege.webprotege.project;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.auto.value.AutoValue;
import edu.stanford.protege.webprotege.dispatch.Action;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 01/04/2013
 */


@JsonTypeName("GetAvailableProjects")
public record GetAvailableProjectsAction() implements Action<GetAvailableProjectsResult> {

}

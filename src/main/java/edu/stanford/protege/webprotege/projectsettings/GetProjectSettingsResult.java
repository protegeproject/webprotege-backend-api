package edu.stanford.protege.webprotege.projectsettings;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.dispatch.Result;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 25/11/14
 */


@JsonTypeName("GetProjectSettings")
public record GetProjectSettingsResult(ProjectSettings settings) implements Result {

}


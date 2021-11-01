package edu.stanford.protege.webprotege.app;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.dispatch.Result;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 16 Mar 2017
 */


@JsonTypeName("webprotege.application.GetApplicationSettings")
public record GetApplicationSettingsResult(ApplicationSettings settings) implements Result {

}

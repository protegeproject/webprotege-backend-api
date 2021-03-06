package edu.stanford.protege.webprotege.app;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.dispatch.Action;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 16 Mar 2017
 */


@JsonTypeName("webprotege.application.GetApplicationSettings")
public record GetApplicationSettingsAction() implements Action<GetApplicationSettingsResult> {

    public static final String CHANNEL = "webprotege.application.GetApplicationSettings";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

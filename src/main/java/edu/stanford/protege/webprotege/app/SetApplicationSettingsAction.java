package edu.stanford.protege.webprotege.app;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.dispatch.Action;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 18 Mar 2017
 */


@JsonTypeName("SetApplicationSettings")
public record SetApplicationSettingsAction(@Nonnull ApplicationSettings applicationSettings) implements Action<SetApplicationSettingsResult> {

    public static final String CHANNEL = "webprotege.application.SetApplicationSettings";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

package edu.stanford.protege.webprotege.permissions;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.dispatch.Action;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 11 Apr 2017
 */
@JsonTypeName("webprotege.auth.RebuildPermissions")
public record RebuildPermissionsAction() implements Action<RebuildPermissionsResult> {

    public static final String CHANNEL = "webprotege.auth.RebuildPermissions";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

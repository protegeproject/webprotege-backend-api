package edu.stanford.protege.webprotege.project;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.authorization.ActionId;
import edu.stanford.protege.webprotege.dispatch.Action;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2020-04-14
 */


@JsonTypeName("webprotege.projects.GetAvailableProjectsWithPermission")
public record GetAvailableProjectsWithPermissionAction(@JsonProperty("permission") @Nonnull ActionId permission) implements Action<GetAvailableProjectsWithPermissionResult> {

    public static final String CHANNEL = "webprotege.projects.GetAvailableProjectsWithPermission";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

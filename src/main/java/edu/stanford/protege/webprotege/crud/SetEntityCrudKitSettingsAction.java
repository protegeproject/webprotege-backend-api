package edu.stanford.protege.webprotege.crud;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ChangeRequest;
import edu.stanford.protege.webprotege.common.ChangeRequestId;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 8/19/13
 */
@JsonTypeName("webprotege.projects.SetEntityCrudKitSettings")
public record SetEntityCrudKitSettingsAction(@JsonProperty("changeRequestId") ChangeRequestId changeRequestId,
                                             @JsonProperty("projectId") ProjectId projectId,
                                             @JsonProperty("fromSettings") EntityCrudKitSettings fromSettings,
                                             @JsonProperty("toSettings") EntityCrudKitSettings toSettings,
                                             @JsonProperty("prefixUpdateStrategy") IRIPrefixUpdateStrategy prefixUpdateStrategy) implements ProjectAction<SetEntityCrudKitSettingsResult>, ChangeRequest {

    public static final String CHANNEL = "webprotege.projects.SetEntityCrudKitSettings";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

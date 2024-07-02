package edu.stanford.protege.webprotege.sharing;

import com.fasterxml.jackson.annotation.*;
import edu.stanford.protege.webprotege.dispatch.Result;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 07/02/15
 */
@JsonTypeName("webprotege.projects.GetProjectSharingSettings")
public record GetProjectSharingSettingsResult(@JsonProperty("settings") ProjectSharingSettings settings) implements Result {

    public GetProjectSharingSettingsResult(ProjectSharingSettings settings) {
        this.settings = checkNotNull(settings);
    }
}

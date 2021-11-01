package edu.stanford.protege.webprotege.perspective;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.Action;
import edu.stanford.protege.webprotege.common.UserId;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 18/02/16
 */


@JsonTypeName("webprotege.perspectives.GetPerspectives")
public record GetPerspectivesAction(@JsonProperty("projectId") ProjectId projectId,
                                    @JsonProperty("userId") UserId userId) implements Action<GetPerspectivesResult> {

    public static final String CHANNEL = "webprotege.perspectives.GetPerspectives";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

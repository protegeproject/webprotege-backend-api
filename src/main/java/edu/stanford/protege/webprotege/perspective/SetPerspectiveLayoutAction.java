package edu.stanford.protege.webprotege.perspective;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ChangeRequest;
import edu.stanford.protege.webprotege.common.ChangeRequestId;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.UserId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 28/02/16
 */
@JsonTypeName("webprotege.perspectives.SetPerspectiveLayout")
public record SetPerspectiveLayoutAction(@Nonnull ChangeRequestId changeRequestId,
                                         @Nonnull ProjectId projectId,
                                         @Nonnull UserId userId,
                                         @Nonnull PerspectiveLayout layout) implements ProjectAction<SetPerspectiveLayoutResult>, ChangeRequest {

    public static final String CHANNEL = "webprotege.perspectives.SetPerspectiveLayout";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

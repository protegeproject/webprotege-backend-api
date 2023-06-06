package edu.stanford.protege.webprotege.perspective;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.common.ChangeRequest;
import edu.stanford.protege.webprotege.common.ChangeRequestId;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2020-09-03
 */
@JsonTypeName("webprotege.perspectives.SetPerspectiveDetails")
public record SetPerspectiveDetailsAction(ChangeRequestId changeRequestId,
                                          ProjectId projectId,
                                          ImmutableList<PerspectiveDetails> perspectiveDetails) implements ProjectAction<SetPerspectiveDetailsResult>, ChangeRequest {

    public static final String CHANNEL = "webprotege.perspectives.SetPerspectiveDetails";


    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

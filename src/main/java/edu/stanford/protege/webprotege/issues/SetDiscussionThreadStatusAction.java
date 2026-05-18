package edu.stanford.protege.webprotege.issues;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ChangeRequestId;
import edu.stanford.protege.webprotege.common.ContentChangeRequest;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 12 Oct 2016
 */
@JsonTypeName("webprotege.discussions.SetDiscussionThreadStatus")
public record SetDiscussionThreadStatusAction(@JsonProperty("changeRequestId") ChangeRequestId changeRequestId,
                                              @JsonProperty("projectId") @Nonnull ProjectId projectId,
                                              @JsonProperty("threadId") @Nonnull ThreadId threadId,
                                              @JsonProperty("status") @Nonnull Status status) implements ProjectAction<SetDiscussionThreadStatusResult>, ContentChangeRequest {

    public static final String CHANNEL = "webprotege.discussions.SetDiscussionThreadStatus";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

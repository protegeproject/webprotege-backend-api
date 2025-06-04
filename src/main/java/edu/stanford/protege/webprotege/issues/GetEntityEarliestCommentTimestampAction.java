package edu.stanford.protege.webprotege.issues;

import com.fasterxml.jackson.annotation.*;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import org.semanticweb.owlapi.model.*;

import static edu.stanford.protege.webprotege.issues.GetEntityEarliestCommentTimestampAction.CHANNEL;

@JsonTypeName(CHANNEL)
public record GetEntityEarliestCommentTimestampAction(
        @JsonProperty("projectId") ProjectId projectId,
        @JsonProperty("entity") OWLEntity entity)
        implements ProjectAction<GetEntityEarliestCommentTimestampResult> {

    public static final String CHANNEL = "webprotege.comments.GetEntityEarliestCommentTimestamp";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

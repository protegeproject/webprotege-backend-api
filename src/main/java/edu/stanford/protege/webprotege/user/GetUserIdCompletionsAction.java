package edu.stanford.protege.webprotege.user;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.dispatch.Action;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 12/05/15
 */
@JsonTypeName("webprotege.users.GetUserIdCompletions")
public record GetUserIdCompletionsAction(String completionText) implements Action<GetUserIdCompletionsResult> {

    public static final String CHANNEL = "webprotege.users.GetUserIdCompletions";

    @Override
    public String getChannel() {
        return CHANNEL;
    }

    public GetUserIdCompletionsAction(String completionText) {
        this.completionText =
                checkNotNull(completionText);
    }
}

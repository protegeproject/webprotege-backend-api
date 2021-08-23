package edu.stanford.protege.webprotege.user;

import edu.stanford.protege.webprotege.dispatch.Action;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 12/05/15
 */
public record GetUserIdCompletionsAction(String completionText) implements Action<GetUserIdCompletionsResult> {

    public static final String CHANNEL = "webprotege.users.GetUserIdCompletions";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

package edu.stanford.protege.webprotege.user;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.dispatch.Result;
import edu.stanford.protege.webprotege.common.UserId;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 12/05/15
 */
@JsonTypeName("webprotege.users.GetUserIdCompletions")
public record GetUserIdCompletionsResult(ImmutableList<UserId> possibleItemCompletions) implements Result {

}

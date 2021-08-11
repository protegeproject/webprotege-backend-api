package edu.stanford.protege.webprotege.itemlist;

import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.dispatch.Result;
import edu.stanford.protege.webprotege.user.UserId;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 12/05/15
 */
public record GetUserIdCompletionsResult(ImmutableList<UserId> possibleItemCompletions) implements Result {

}

package edu.stanford.protege.webprotege.itemlist;

import edu.stanford.protege.webprotege.dispatch.Action;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 12/05/15
 */
public record GetPersonIdCompletionsAction(String completionText) implements Action<GetPersonIdCompletionsResult> {

}

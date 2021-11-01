package edu.stanford.protege.webprotege.dispatch;

import edu.stanford.protege.webprotege.common.Request;


/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 20/01/2013
 * <p>
 *     The basic interface for actions that are sent to the dispatch service
 * </p>
 */
public interface Action<R extends Result> extends Request<R> {
}

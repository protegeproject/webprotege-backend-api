package edu.stanford.protege.webprotege.frame;

import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.dispatch.Result;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 25/07/15
 */
public record GetOntologyFramesResult(ImmutableList<OntologyFrame> frames) implements Result {

}

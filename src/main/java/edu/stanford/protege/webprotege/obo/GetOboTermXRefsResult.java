package edu.stanford.protege.webprotege.obo;

import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.dispatch.Result;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 22 Jun 2017
 */
public record GetOboTermXRefsResult(ImmutableList<OBOXRef> xRefs) implements Result {

}

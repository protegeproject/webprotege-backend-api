package edu.stanford.protege.webprotege.watches;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.dispatch.Result;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 29/02/16
 */


@JsonTypeName("webprotege.watches.SetWatches")
public record SetWatchesResult() implements Result {

}

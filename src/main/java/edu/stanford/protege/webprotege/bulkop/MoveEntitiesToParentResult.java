package edu.stanford.protege.webprotege.bulkop;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.dispatch.Result;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 25 Sep 2018
 */


@JsonTypeName("MoveEntitiesToParent")
public record MoveEntitiesToParentResult() implements Result {

}

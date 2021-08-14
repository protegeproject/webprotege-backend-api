package edu.stanford.protege.webprotege.change;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.dispatch.Result;
import edu.stanford.protege.webprotege.common.Page;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 27/02/15
 */
@JsonTypeName("GetWatchedEntityChanges")
public record GetWatchedEntityChangesResult(Page<ProjectChange> changes) implements Result {

}

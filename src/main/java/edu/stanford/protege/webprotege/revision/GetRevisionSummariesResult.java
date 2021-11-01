package edu.stanford.protege.webprotege.revision;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.common.Page;
import edu.stanford.protege.webprotege.dispatch.Result;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 21/02/15
 */
@JsonTypeName("webprotege.history.GetRevisionSummaries")
public record GetRevisionSummariesResult(Page<RevisionSummary> revisionSummaries) implements Result {

}

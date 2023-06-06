package edu.stanford.protege.webprotege.revision;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.Page;
import edu.stanford.protege.webprotege.dispatch.Result;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 21/02/15
 */
@JsonTypeName("webprotege.history.GetRevisionSummaries")
public record GetRevisionSummariesResult(Page<RevisionSummary> revisionSummaries) implements Result {

    public GetRevisionSummariesResult(Page<RevisionSummary> revisionSummaries) {
        this.revisionSummaries = checkNotNull(revisionSummaries);
    }
}

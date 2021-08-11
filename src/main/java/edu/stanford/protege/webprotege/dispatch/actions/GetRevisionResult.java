package edu.stanford.protege.webprotege.dispatch.actions;

import edu.stanford.protege.webprotege.dispatch.Result;
import edu.stanford.protege.webprotege.revision.RevisionDetails;

import javax.annotation.Nonnull;
import java.util.Optional;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 9 May 2018
 */
public record GetRevisionResult(RevisionDetails revisionDetails) implements Result {

    @Nonnull
    public Optional<RevisionDetails> getRevisionDetails() {
        return Optional.ofNullable(revisionDetails);
    }
}

package edu.stanford.protege.webprotege.change;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.Page;
import edu.stanford.protege.webprotege.dispatch.Result;

import java.util.Objects;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 24/02/15
 */
@JsonTypeName("webprotege.history.GetProjectChanges")
public record GetProjectChangesResult(@JsonProperty("projectChanges") Page<ProjectChange> changes) implements Result {

    public GetProjectChangesResult {
        Objects.requireNonNull(changes);
    }
}


package edu.stanford.protege.webprotege.bulkop;

import com.fasterxml.jackson.annotation.*;
import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.common.*;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import org.semanticweb.owlapi.model.*;

import javax.annotation.Nonnull;

@JsonTypeName(MoveEntitiesToParentIcdAction.CHANNEL)
public record MoveEntitiesToParentIcdAction(@JsonProperty("changeRequestId") ChangeRequestId changeRequestId,
                                            @JsonProperty("projectId") @Nonnull ProjectId projectId,
                                            @JsonProperty("entities") @Nonnull ImmutableSet<OWLClass> entities,
                                            @JsonProperty("parentEntity") @Nonnull OWLClass parentEntity,
                                            @JsonProperty("commitMessage") @Nonnull String commitMessage) implements ProjectAction<MoveEntitiesToParentIcdResult>, HasCommitMessage, ContentChangeRequest {

    public static final String CHANNEL = "webprotege.entities.MoveEntitiesToParentIcd";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

package edu.stanford.protege.webprotege.bulkop;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import org.semanticweb.owlapi.model.OWLClass;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 25 Sep 2018
 */


@JsonTypeName("webprotege.entities.MoveEntitiesToParent")
public record MoveEntitiesToParentAction(@JsonProperty("projectId") @Nonnull ProjectId projectId,
                                         @JsonProperty("entities") @Nonnull ImmutableSet<OWLClass> entities,
                                         @JsonProperty("parentEntity") @Nonnull OWLClass entity,
                                         @JsonProperty("commitMessage") @Nonnull String commitMessage) implements ProjectAction<MoveEntitiesToParentResult>, HasCommitMessage {

    public static final String CHANNEL = "webprotege.entities.MoveEntitiesToParent";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

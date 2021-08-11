package edu.stanford.protege.webprotege.bulkop;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import edu.stanford.protege.webprotege.common.ProjectId;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLEntity;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 25 Sep 2018
 */


@JsonTypeName("MoveEntitiesToParent")
public record MoveEntitiesToParentAction(@JsonProperty("projectId") @Nonnull ProjectId projectId,
                                         @JsonProperty("entities") @Nonnull ImmutableSet<OWLClass> entities,
                                         @JsonProperty("parentEntity") @Nonnull OWLClass entity,
                                         @JsonProperty("commitMessage") @Nonnull String commitMessage) implements ProjectAction<MoveEntitiesToParentResult>, HasCommitMessage {

}

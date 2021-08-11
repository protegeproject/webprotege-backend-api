package edu.stanford.protege.webprotege.bulkop;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import edu.stanford.protege.webprotege.common.ProjectId;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLEntity;

import javax.annotation.Nonnull;
import java.util.Optional;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 24 Sep 2018
 */


@JsonTypeName("EditAnnotations")
public record EditAnnotationsAction(@JsonProperty("projectId") @Nonnull ProjectId projectId,
                                    @JsonProperty("entities") @Nonnull ImmutableSet<OWLEntity> entities,
                                    @JsonProperty("operation") Operation operation,
                                    @JsonProperty("property") @Nonnull Optional<OWLAnnotationProperty> property,
                                    @JsonProperty("lexicalValueExpression") @Nonnull Optional<String> lexicalValueExpression,
                                    @JsonProperty("lexicalValueExpressionIsRegEx") boolean lexicalValueExpressionIsRegEx,
                                    @JsonProperty("langTagExpression") @Nonnull Optional<String> langTagExpression,
                                    @JsonProperty("newAnnotationData") @Nonnull NewAnnotationData newAnnotationData,
                                    @JsonProperty("commitMessage") @Nonnull String commitMessage) implements ProjectAction<EditAnnotationsResult>, HasCommitMessage {
}

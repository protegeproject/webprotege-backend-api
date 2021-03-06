package edu.stanford.protege.webprotege.bulkop;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.common.ChangeRequestId;
import edu.stanford.protege.webprotege.common.ContentChangeRequest;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLAnnotationValue;
import org.semanticweb.owlapi.model.OWLEntity;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 24 Sep 2018
 */


@JsonTypeName("webprotege.bulkop.SetAnnotationValue")
public record SetAnnotationValueAction(ChangeRequestId changeRequestId,
                                       @JsonProperty("projectId") @Nonnull ProjectId projectId,
                                       @JsonProperty("entities") @Nonnull ImmutableSet<OWLEntity> entities,
                                       @JsonProperty("property") @Nonnull OWLAnnotationProperty property,
                                       @JsonProperty("value") @Nonnull OWLAnnotationValue value,
                                       @JsonProperty("commitMessage") @Nonnull String commitMessage) implements ProjectAction<SetAnnotationValueResult>, HasCommitMessage, ContentChangeRequest {

    public static final String CHANNEL = "webprotege.bulkop.SetAnnotationValue";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

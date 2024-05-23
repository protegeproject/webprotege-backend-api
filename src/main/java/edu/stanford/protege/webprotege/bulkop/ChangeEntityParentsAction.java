package edu.stanford.protege.webprotege.bulkop;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.common.ChangeRequestId;
import edu.stanford.protege.webprotege.common.ContentChangeRequest;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import org.semanticweb.owlapi.model.OWLClass;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 25 Sep 2018
 */


@JsonTypeName("webprotege.entities.ChangeEntityParents")
public record ChangeEntityParentsAction(@JsonProperty("changeRequestId") ChangeRequestId changeRequestId,
                                        @JsonProperty("projectId") @Nonnull ProjectId projectId,
                                        @JsonProperty("entity") @Nonnull OWLClass entity,
                                        @JsonProperty("parents") @Nonnull ImmutableSet<OWLClass> parents,
                                        @JsonProperty("commitMessage") @Nonnull String commitMessage) implements ProjectAction<ChangeEntityParentsResult>, HasCommitMessage, ContentChangeRequest {

    public static final String CHANNEL = "webprotege.entities.ChangeEntityParents";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

package edu.stanford.protege.webprotege.entity;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import org.semanticweb.owlapi.model.OWLEntity;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 9 Mar 2018
 *
 * Creates a {@link MergeEntitiesAction}.  An term merge is directional – one term is merged into
 * another term.
 * @param projectId The project to perform the merge in.
 * @param sourceEntities The entities that will be merged into another term.
 * @param targetEntity The term that will have the source term merged into it.
 * @param treatment The treatment for the merged term that specifies whether the merged term
 *                  will be deleted or deprecated.
 */
@JsonTypeName("MergeEntities")
public record MergeEntitiesAction(@Nonnull ProjectId projectId,
                                  @Nonnull ImmutableSet<OWLEntity> sourceEntities,
                                  @Nonnull OWLEntity targetEntity,
                                  @Nonnull MergedEntityTreatment treatment,
                                  @Nonnull String commitMessage) implements ProjectAction<MergeEntitiesResult> {

    public static final String CHANNEL = "webprotege.entities.MergeEntities";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

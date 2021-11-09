package edu.stanford.protege.webprotege.entity;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import org.semanticweb.owlapi.model.OWLEntity;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 9 May 2017
 */
@JsonTypeName("webprotege.entities.DeleteEntities")
public record DeleteEntitiesAction(ProjectId projectId,
                                   ImmutableSet<OWLEntity> entities) implements ProjectAction<DeleteEntitiesResult> {

    public static final String CHANNEL = "webprotege.entities.DeleteEntities";

    @Override
    public String getChannel() {
        return CHANNEL;
    }

    public DeleteEntitiesAction(ProjectId projectId, ImmutableSet<OWLEntity> entities) {
        this.projectId = checkNotNull(projectId);
        this.entities = checkNotNull(entities);
    }
}

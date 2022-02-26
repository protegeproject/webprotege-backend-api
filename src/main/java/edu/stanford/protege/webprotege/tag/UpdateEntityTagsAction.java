package edu.stanford.protege.webprotege.tag;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ChangeRequest;
import edu.stanford.protege.webprotege.common.ChangeRequestId;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import org.semanticweb.owlapi.model.OWLEntity;

import javax.annotation.Nonnull;
import java.util.Set;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 21 Mar 2018
 */
@JsonTypeName("webprotege.tags.UpdateEntityTags")
public record UpdateEntityTagsAction(@Nonnull ChangeRequestId changeRequestId,
                                     @Nonnull ProjectId projectId,
                                     @Nonnull OWLEntity entity,
                                     @Nonnull Set<TagId> fromTagIds,
                                     @Nonnull Set<TagId> toTagIds) implements ProjectAction<UpdateEntityTagsResult>, ChangeRequest {

    public static final String CHANNEL = "webprotege.tags.UpdateEntityTags";

    @Override
    public String getChannel() {
        return CHANNEL;
    }

    public UpdateEntityTagsAction(ChangeRequestId changeRequestId, @Nonnull ProjectId projectId,
                                  @Nonnull OWLEntity entity,
                                  @Nonnull Set<TagId> fromTagIds,
                                  @Nonnull Set<TagId> toTagIds) {
        this.changeRequestId = checkNotNull(changeRequestId);
        this.projectId = checkNotNull(projectId);
        this.entity = checkNotNull(entity);
        this.fromTagIds = checkNotNull(fromTagIds);
        this.toTagIds = checkNotNull(toTagIds);
    }
}

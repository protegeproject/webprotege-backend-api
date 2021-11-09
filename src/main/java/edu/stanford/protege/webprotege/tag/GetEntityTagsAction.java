package edu.stanford.protege.webprotege.tag;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import org.semanticweb.owlapi.model.OWLEntity;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 18 Mar 2018
 */
@JsonTypeName("webprotege.tags.GetEntityTags")
public record GetEntityTagsAction(ProjectId projectId, OWLEntity entity) implements ProjectAction<GetEntityTagsResult> {

    public static final String CHANNEL = "webprotege.tags.GetEntityTags";

    @Override
    public String getChannel() {
        return CHANNEL;
    }

    public GetEntityTagsAction(ProjectId projectId, OWLEntity entity) {
        this.projectId = checkNotNull(projectId);
        this.entity = checkNotNull(entity);
    }
}

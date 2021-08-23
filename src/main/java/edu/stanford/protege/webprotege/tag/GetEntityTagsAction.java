package edu.stanford.protege.webprotege.tag;

import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import org.semanticweb.owlapi.model.OWLEntity;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 18 Mar 2018
 */
public record GetEntityTagsAction(ProjectId projectId, OWLEntity entity) implements ProjectAction<GetEntityTagsResult> {

    @Override
    public String getChannel() {
        return "webprotege.tags.GetEntityTags";
    }
}

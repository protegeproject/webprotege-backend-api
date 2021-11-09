package edu.stanford.protege.webprotege.tag;


import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 18 Mar 2018
 */
@JsonTypeName("webprotege.tags.GetProjectTags")
public record GetProjectTagsAction(ProjectId projectId) implements ProjectAction<GetProjectTagsResult> {

    public static final String CHANNEL = "webprotege.tags.GetProjectTags";

    @Override
    public String getChannel() {
        return CHANNEL;
    }

    public GetProjectTagsAction(ProjectId projectId) {
        this.projectId = checkNotNull(projectId);
    }
}

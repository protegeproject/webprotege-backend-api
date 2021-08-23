package edu.stanford.protege.webprotege.lang;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2020-04-26
 */
@JsonTypeName("GetProjectLangTags")
public record GetProjectLangTagsAction(ProjectId projectId) implements ProjectAction<GetProjectLangTagsResult> {

    public static final String CHANNEL = "webprotege.project.GetProjectLangTags";

    public static GetProjectLangTagsAction create(@Nonnull ProjectId projectId) {
        return new GetProjectLangTagsAction(projectId);
    }

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

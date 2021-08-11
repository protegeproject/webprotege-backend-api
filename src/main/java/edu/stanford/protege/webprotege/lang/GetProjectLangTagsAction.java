package edu.stanford.protege.webprotege.lang;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.base.MoreObjects;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;
import edu.stanford.protege.webprotege.common.ProjectId;

import javax.annotation.Nonnull;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2020-04-26
 */
@JsonTypeName("GetProjectLangTags")
public record GetProjectLangTagsAction(ProjectId projectId) implements ProjectAction<GetProjectLangTagsResult> {

    public static GetProjectLangTagsAction create(@Nonnull ProjectId projectId) {
        return new GetProjectLangTagsAction(projectId);
    }

}

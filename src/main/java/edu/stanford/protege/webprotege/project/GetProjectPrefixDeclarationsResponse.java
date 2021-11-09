package edu.stanford.protege.webprotege.project;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.Result;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 27 Feb 2018
 */
@JsonTypeName("webprotege.projects.GetProjectPrefixDeclarations")
public record GetProjectPrefixDeclarationsResponse(ProjectId projectId, ImmutableList<PrefixDeclaration> prefixDeclarations) implements Result {

    public GetProjectPrefixDeclarationsResponse(ProjectId projectId,
                                                ImmutableList<PrefixDeclaration> prefixDeclarations) {
        this.projectId = checkNotNull(projectId);
        this.prefixDeclarations = checkNotNull(prefixDeclarations);
    }
}

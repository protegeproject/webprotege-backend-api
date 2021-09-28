package edu.stanford.protege.webprotege.project;

import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.Result;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 27 Feb 2018
 */
public record GetProjectPrefixDeclarationsResponse(ProjectId projectId, ImmutableList<PrefixDeclaration> prefixDeclarations) implements Result {

}

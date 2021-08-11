package edu.stanford.protege.webprotege.project;

import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.Result;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 1 Mar 2018
 */
public record SetProjectPrefixDeclarationsResult(@Nonnull ProjectId projectId,
                                                @Nonnull List<PrefixDeclaration> prefixDeclarations) implements Result {

}

package edu.stanford.protege.webprotege.project;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.Result;

import javax.annotation.Nonnull;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 1 Mar 2018
 */
@JsonTypeName("webprotege.projects.SetProjectPrefixDeclarations")
public record SetProjectPrefixDeclarationsResult(@Nonnull ProjectId projectId,
                                                @Nonnull List<PrefixDeclaration> prefixDeclarations) implements Result {

    public SetProjectPrefixDeclarationsResult(@Nonnull ProjectId projectId,
                                              @Nonnull List<PrefixDeclaration> prefixDeclarations) {
        this.projectId = checkNotNull(projectId);
        this.prefixDeclarations = checkNotNull(prefixDeclarations);
    }
}

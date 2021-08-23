package edu.stanford.protege.webprotege.project;

import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 1 Mar 2018
 */
public record SetProjectPrefixDeclarationsAction(@Nonnull ProjectId projectId,
                                                 @Nonnull List<PrefixDeclaration> prefixDeclarations) implements ProjectAction<SetProjectPrefixDeclarationsResult> {

    public static final String CHANNEL = "webprotege.projects.SetProjectPrefixDeclarations";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

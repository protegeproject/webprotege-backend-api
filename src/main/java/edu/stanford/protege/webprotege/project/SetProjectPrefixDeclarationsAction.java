package edu.stanford.protege.webprotege.project;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ChangeRequest;
import edu.stanford.protege.webprotege.common.ChangeRequestId;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;

import javax.annotation.Nonnull;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 1 Mar 2018
 */
@JsonTypeName("webprotege.projects.SetProjectPrefixDeclarations")
public record SetProjectPrefixDeclarationsAction(@Nonnull ChangeRequestId changeRequestId,
                                                 @Nonnull ProjectId projectId,
                                                 @Nonnull List<PrefixDeclaration> prefixDeclarations) implements ProjectAction<SetProjectPrefixDeclarationsResult>, ChangeRequest {

    public static final String CHANNEL = "webprotege.projects.SetProjectPrefixDeclarations";

    @Override
    public String getChannel() {
        return CHANNEL;
    }

    public SetProjectPrefixDeclarationsAction(ChangeRequestId changeRequestId, @Nonnull ProjectId projectId,
                                              @Nonnull List<PrefixDeclaration> prefixDeclarations) {
        this.changeRequestId = checkNotNull(changeRequestId);
        this.projectId = checkNotNull(projectId);
        this.prefixDeclarations = checkNotNull(prefixDeclarations);
    }
}

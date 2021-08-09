package edu.stanford.protege.webprotege.project;

import com.google.common.base.Objects;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.dispatch.ProjectAction;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.MoreObjects.toStringHelper;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 1 Mar 2018
 */
public class SetProjectPrefixDeclarationsAction implements ProjectAction<SetProjectPrefixDeclarationsResult> {

    private ProjectId projectId;

    private List<PrefixDeclaration> prefixDeclarations;

    private SetProjectPrefixDeclarationsAction(@Nonnull ProjectId projectId,
                                               @Nonnull List<PrefixDeclaration> prefixDeclarations) {
        this.projectId = checkNotNull(projectId);
        this.prefixDeclarations = new ArrayList<>(checkNotNull(prefixDeclarations));
    }


    private SetProjectPrefixDeclarationsAction() {
    }

    public static SetProjectPrefixDeclarationsAction create(@Nonnull ProjectId projectId,
                                                            @Nonnull List<PrefixDeclaration> prefixDeclarations) {
        return new SetProjectPrefixDeclarationsAction(projectId, prefixDeclarations);
    }

    @Nonnull
    @Override
    public ProjectId getProjectId() {
        return projectId;
    }

    /**
     * Gets the prefix declarations to set
     */
    @Nonnull
    public List<PrefixDeclaration> getPrefixDeclarations() {
        return new ArrayList<>(prefixDeclarations);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(projectId, prefixDeclarations);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetProjectPrefixDeclarationsAction)) {
            return false;
        }
        SetProjectPrefixDeclarationsAction other = (SetProjectPrefixDeclarationsAction) obj;
        return this.projectId.equals(other.projectId)
                && this.prefixDeclarations.equals(other.prefixDeclarations);
    }


    @Override
    public String toString() {
        return toStringHelper("SetProjectPrefixDeclarationsAction")
                .addValue(projectId)
                .addValue(prefixDeclarations)
                .toString();
    }
}
